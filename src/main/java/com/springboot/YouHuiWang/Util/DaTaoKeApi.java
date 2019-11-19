package com.springboot.YouHuiWang.Util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.TreeMap;

@Component
public class DaTaoKeApi {


    //staic 变量无法通过@Value直接注入 需要通过set方法注入
    private static String appSecret;//应用sercret

    private static String appKey; //应用key

    private static String host;//应用服务接口

    private static int timing; //定时任务 定时时间


    /**
     * 添加Version page等信息
     *
     * @param pageId
     * @return
     */
    private static TreeMap<String, String> putInfoPre(String pageId) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("version", "v1.1.0");
        map.put("pageSize", "200");
        if (pageId == null || pageId == "") {
            map.put("pageId", "1");
        } else {
            map.put("pageId", pageId);
        }
        return map;
    }


    /**
     * sign认证 放到最后
     *
     * @param paraMap
     * @return
     */
    private static TreeMap<String, String> putInfoAfter(TreeMap<String, String> paraMap) {
        paraMap.put("appKey", appKey);
        paraMap.put("sign", SignMD5Util.getSignStr(paraMap, appSecret));
        System.out.println(paraMap);
        return paraMap;
    }


    /**
     * 获取商品列表
     *
     * @return
     */
    public static String getGoodsList(String pageId) {
        TreeMap<String, String> map = putInfoPre(pageId);
        map.putAll(putInfoAfter(map));
        return DaTaoKeHttpUtils.sendGet(host + "goods/get-goods-list", map);
    }


    /**
     * 定时更新
     *
     * @return
     */
    public static String pullGoodsByTime(String pageId, String startTime) {

        TreeMap<String, String> map = putInfoPre(pageId);
        map.put("startTime", startTime);
        // map.put("endTime",endTime);
        map.putAll(putInfoAfter(map));

        return DaTaoKeHttpUtils.sendGet(host + "goods/pull-goods-by-time", map);
    }


    /**
     * 商品更新
     *
     * @param pageId
     * @return
     */
    public static String getNewestGoods(String pageId) {
        TreeMap<String, String> map = putInfoPre(pageId);
        map.putAll(putInfoAfter(map));
        return DaTaoKeHttpUtils.sendGet(host + "goods/get-newest-goods", map);
    }


    /**
     * 获取失效商品
     *
     * @param pageId
     * @param startTime
     * @return
     */
    public static String getStaleGoodsByTime(String pageId, String startTime) {

        TreeMap<String, String> map = putInfoPre(pageId);
        map.put("startTime", startTime);
        // map.put("endTime",endTime);
        map.putAll(putInfoAfter(map));

        return DaTaoKeHttpUtils.sendGet(host + "goods/get-stale-goods-by-time", map);
    }


    /**
     * 获取商品单品信息
     *
     * @param id
     * @return
     */
    public static String getGoodsDetails(int id) {

        TreeMap<String, String> map = new TreeMap<>();
        map.put("version", "v1.1.0");
        map.put("id", id + "");
        map.putAll(putInfoAfter(map));
        return DaTaoKeHttpUtils.sendGet(host + "goods/get-goods-details", map);
    }


    /**
     * 获取超级分类
     *
     * @return
     */
    public static String getSuperCategory() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("version", "v1.1.0");
        map.putAll(putInfoAfter(map));
        return DaTaoKeHttpUtils.sendGet(host + "category/get-super-category", map);
    }


    /**
     * 联想词搜索
     *
     * @param keyWords
     * @return
     */
    public static String getSearchSuggestion(String keyWords) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("version", "v1.1.0");
        map.put("keyWords", keyWords);
        map.put("type", "1");
        map.putAll(putInfoAfter(map));
        return DaTaoKeHttpUtils.sendGet(host + "goods/search-suggestion", map);
    }


    /**
     * 热搜
     *
     * @return
     */
    public static String getHotSearch() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("version", "v1.0.1");
        map.putAll(putInfoAfter(map));
        return DaTaoKeHttpUtils.sendGet(host + "category/get-top100", map);
    }


    /**
     * 高效转链
     * @param goodsId
     * @return
     */
    public static String getPrivilegeLink(String goodsId){
        TreeMap<String, String> map = new TreeMap<>();
        map.put("version", "v1.1.0");
        map.put("goodsId", goodsId);
        map.putAll(putInfoAfter(map));
        return DaTaoKeHttpUtils.sendGet(host + "tb-service/get-privilege-link", map);
    }

    @Value("${appSecret}")
    public void setAppSecret(String appSecret) {
        DaTaoKeApi.appSecret = appSecret;
    }

    @Value("${appKey}")
    public void setAppKey(String appKey) {
        DaTaoKeApi.appKey = appKey;
    }

    @Value("${host}")
    public void setHost(String host) {
        DaTaoKeApi.host = host;
    }

    @Value("${timing}")
    public static void setTiming(int timing) {
        DaTaoKeApi.timing = timing;
    }
}
