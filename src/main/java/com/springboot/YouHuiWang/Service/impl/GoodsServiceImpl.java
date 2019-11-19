package com.springboot.YouHuiWang.Service.impl;

import com.springboot.YouHuiWang.Pojo.*;
import com.springboot.YouHuiWang.Util.CodeUtil;
import com.springboot.YouHuiWang.Util.DaTaoKeApi;
import com.springboot.YouHuiWang.Mapper.GoodsMapper;
import com.springboot.YouHuiWang.Service.GoodsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.YouHuiWang.Mapper.SubCidTableMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2019-10-14
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private SubCidTableMapper subCidTableMapper;


    /**
     * api 接口区
     */

    /**
     * 获取api全部商品到数据库中
     *
     * @return
     */
    public int getGoodsListToDB() {

        return putInDB(DaTaoKeApi.class, "getGoodsList", new Object[]{""});
    }

    /**
     * 定时拉取最新数据
     *
     * @param startTime
     * @return
     */
    @Override
    public int pullGoodsByTimeToDB(String startTime) {
        return putInDB(DaTaoKeApi.class, "pullGoodsByTime", new Object[]{"", startTime});
    }


    /**
     * 更新api全部商品到数据库中
     *
     * @return
     */
    @Override
    public int updateGoodsListToDB() {
        String json = DaTaoKeApi.getNewestGoods(null);
        JSONObject jsonObject = JSONObject.fromObject(json);
        int totalSize = 0;
        int goodsSize = jsonObject.getJSONObject("data").getJSONArray("list").size();
        String pageId = jsonObject.getJSONObject("data").getString("pageId");

        while (goodsSize != 0) {
            System.out.println("goodSize:" + goodsSize);

            int addSize = updateGoodsInDB(json);

            totalSize = totalSize + addSize;

            // 当更新的数据不到10条时候 停止获取新数据 并且返回
            if (addSize < 10) {
                return totalSize;
            }


            json = DaTaoKeApi.getNewestGoods(pageId);

            jsonObject = JSONObject.fromObject(json);

            if (jsonObject == null) {
                return totalSize;
            }
            goodsSize = jsonObject.getJSONObject("data").getJSONArray("list").size();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }


    /**
     * 获取失效商品api 从数据库中删除失效商品
     *
     * @param startTime
     * @return
     */
    @Override
    public int getStaleGoodsByTimeToDB(String startTime) {

        //获取json
        String json = DaTaoKeApi.getStaleGoodsByTime(null, startTime);
        JSONObject jsonObject = JSONObject.fromObject(json);

        int total = 0;

        //判断是否成功获取
        if (CodeUtil.isSuccessForDaTaoKe(json)) {
            String pageId = null;

            List<Goods> goodsListForJson = jsonObject.getJSONObject("data").getJSONArray("list");
            int goodsListSizes = goodsListForJson.size();
            while (goodsListSizes != 0) {

                pageId = jsonObject.getJSONObject("data").getString("pageId");

                List<Integer> goodsIdList = new ArrayList();

                Iterator iterator = goodsListForJson.iterator();

                //获取商品id
                while (iterator.hasNext()) {
                    goodsIdList.add(((JSONObject) iterator.next()).getInt("id"));
                }

                //数据库匹配删除
                int deleteSize = 0;
                if (goodsIdList.size() != 0) {
                    deleteSize = goodsMapper.deleteAllGoodsById(goodsIdList);
                    subCidTableMapper.deleteAllSubCidById(goodsIdList);
                }

                total = total + deleteSize;

                //当删除的数量小于10 不再获取删除
                if (deleteSize < 1) {
                    return total;
                }


                json = DaTaoKeApi.getStaleGoodsByTime(pageId, startTime);
                jsonObject = JSONObject.fromObject(json);
                if (jsonObject != null && CodeUtil.isSuccessForDaTaoKe(json)) {
                    goodsListForJson = jsonObject.getJSONObject("data").getJSONArray("list");
                    goodsListSizes = goodsListForJson.size();
                }

            }
        }
        return total;
    }

    /**
     * 获取商品详细信息
     *
     * @param id
     * @return
     */
    @Override
    public GoodsDetails getGoodsDetailsById(int id) {

        String json = DaTaoKeApi.getGoodsDetails(id);

        JSONObject jsonObject = JSONObject.fromObject(json);

        System.out.println(json);
        //如果成功获取 返回
        if (CodeUtil.isSuccessForDaTaoKe(json)) {
            JSONObject goodsDetailsJson = jsonObject.getJSONObject("data");
            GoodsDetails goodsDetails = (GoodsDetails) JSONObject.toBean(goodsDetailsJson, GoodsDetails.class);
            System.out.println(goodsDetails);
            return goodsDetails;
        } else {
            List list = new ArrayList();
            list.add(id);
            goodsMapper.deleteAllGoodsById(list);
            new RuntimeException(CodeUtil.getErrorMsgDaTaoKe(json)).printStackTrace();

            return null;
        }
    }

    /**
     * 通过结束时间删除goods
     * @param couponEndTime
     * @return
     */
    @Override
    public int deleteAllGoodsByCouponEndTime(String couponEndTime) {
        return goodsMapper.deleteAllGoodsByCouponEndTime(couponEndTime);
    }


    /**
     * 数据库接口区
     */

    /**
     * 获取商品单品信息 通过数据库获取
     *
     * @param
     * @return
     */
    @Override
    public List<GoodsList> selectGoodsList(Goods goods) {
        return goodsMapper.selectGoodsList(goods);
    }


    /**
     * 反射区
     * 通过类名 方法名 参数放射执行方法
     * 其中putInDB对存数据库进行封装
     */
    protected int putInDB(Class className, String methodName, Object[] params) {
        //获取json数据
        String json = (String) getInvoke(className, methodName, params);
        //计算插入总量
        int totalSize = 0;
        if (CodeUtil.isSuccessForDaTaoKe(json)) {

            JSONObject jsonObject = JSONObject.fromObject(json);
            int goodsSize = jsonObject.getJSONObject("data").getJSONArray("list").size();
            String pageId = jsonObject.getJSONObject("data").getString("pageId");


            //当json中的数据不为0时
            while (goodsSize != 0) {
                System.out.println("goodsSize:" + goodsSize);

                //添加个数
                int addSize = putGoodsInDB(json);

                //总量
                totalSize = totalSize + addSize;

                //替换pageId
                params[0] = pageId;

               // System.out.println("putInDB pageId：" + pageId);

                // 当插入的数据不到10条时候 停止获取新数据 并且返回
                if (addSize < 10) {
                    return totalSize;
                }


                json = (String) getInvoke(className, methodName, params);

                if (CodeUtil.isSuccessForDaTaoKe(json)) {
                    jsonObject = JSONObject.fromObject(json);
                    goodsSize = jsonObject.getJSONObject("data").getJSONArray("list").size();

                } else {
                    return totalSize;
                }


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return totalSize;
    }


    /**
     * 反射 通过 类名 方法名 参数执行方法
     *
     * @param className
     * @param methodName
     * @param params
     * @return
     */
    protected Object getInvoke(Class className, String methodName, Object[] params) {
        try {


            Object object = className.getInterfaces();
            Class classParams[] = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                classParams[i] = params[i].getClass();
            }
            Method method = className.getDeclaredMethod(methodName, classParams);
            return method.invoke(object, params);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 数据库区
     */

    /**
     * getGoodsListToDB调用本方法
     * 商品信息批量插入数据库
     *
     * @return
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    protected int putGoodsInDB(String json) {

        int putInDB_GoodsSize = 0;

        //判断是否成功获取
        if (CodeUtil.isSuccessForDaTaoKe(json)) {
            //转换为JSONObject
            JSONObject jsonObject = JSONObject.fromObject(json);

            //获取goods列表
            List<Goods> goodsListForJson = jsonObject.getJSONObject("data").getJSONArray("list");

            System.out.println(goodsListForJson);

            List<SubCidTable> subCidTables = new ArrayList<>();
            List<Goods> goodsList = new ArrayList<>();

            if (goodsListForJson.size() != 0) {
                Iterator iterator = goodsListForJson.iterator();

                //遍历goods列表
                while (iterator.hasNext()) {
                    Goods goods = (Goods) JSONObject.toBean((JSONObject) iterator.next(), Goods.class);
                    int id = goods.getId();
                    List<Integer> goodsSubcid = goods.getSubcid();
                    //构造SubCitTable
                    for (int subCid : goodsSubcid) {
                        subCidTables.add(new SubCidTable(id, subCid));
                    }
                    goodsList.add(goods);
                }


                if (goodsList.size() != 0) {
                    putInDB_GoodsSize = goodsMapper.insertAllGoods(goodsList);
                }
                if (subCidTables.size() != 0) {
                    subCidTableMapper.insertAllSubCid(subCidTables);
                }
                return putInDB_GoodsSize;
            }
            return 0;
        } else {
            new RuntimeException(CodeUtil.getErrorMsgDaTaoKe(json)).printStackTrace();
        }
        return 0;
    }


    /**
     * updateGoodsListToDB
     * 批量更新subcit
     *
     * @param json
     * @return
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    protected int updateGoodsInDB(String json) {
        int putInDB_GoodsSize = 0;

        //判断是否成功获取
        if (CodeUtil.isSuccessForDaTaoKe(json)) {
            //转换为JSONObject
            JSONObject jsonObject = JSONObject.fromObject(json);

            //获取goods列表
            List<GoodsUpdate> goodsUpdateForJson = jsonObject.getJSONObject("data").getJSONArray("list");

            System.out.println(goodsUpdateForJson);

            List<SubCidTable> subCidTables = new ArrayList<>();
            List<GoodsUpdate> goodsUpdateList = new ArrayList<>();

            //当数据少于50条则不在继续获取
            if (goodsUpdateForJson.size() != 0) {
                Iterator iterator = goodsUpdateForJson.iterator();

                //遍历goods列表
                while (iterator.hasNext()) {
                    GoodsUpdate goodsUpdate = (GoodsUpdate) JSONObject.toBean((JSONObject) iterator.next(), GoodsUpdate.class);
                    int id = goodsUpdate.getId();
                    List<Integer> goodsSubcid = goodsUpdate.getSubcid();
                    //构造SubCitTable
                    for (int subCid : goodsSubcid) {
                        subCidTables.add(new SubCidTable(id, subCid));
                    }
                    goodsUpdateList.add(goodsUpdate);
                }
                if (goodsUpdateList.size() != 0) {
                    putInDB_GoodsSize = goodsMapper.updateAllGoods(goodsUpdateList);
                }
                if (subCidTables.size() != 0) {
                    subCidTableMapper.updateAllSubCidById(subCidTables);
                }
                return putInDB_GoodsSize;
            }
            return 0;
        } else {
            new RuntimeException(CodeUtil.getErrorMsgDaTaoKe(json)).printStackTrace();
        }
        return 0;
    }

    /**
     * getStaleGoodsByTimeToDB调用 从数据中中删除失效商品
     *
     * @param goodsIdList
     * @return
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    protected int deleteGoodsInDB(List<Integer> goodsIdList) {
        int deleteSizse = 0;
        if (goodsIdList.size() != 0) {
            deleteSizse = goodsMapper.deleteAllGoodsById(goodsIdList);
            subCidTableMapper.deleteAllSubCidById(goodsIdList);
        }
        return deleteSizse;
    }


}
