package com.springboot.YouHuiWang.Mapper;

import com.springboot.YouHuiWang.Pojo.Goods;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.YouHuiWang.Pojo.GoodsList;
import com.springboot.YouHuiWang.Pojo.GoodsUpdate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2019-10-14
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    //批量插入goods
    public int insertAllGoods(List<Goods> goodsList);

    //批量更新goods
    public int updateAllGoods(List<GoodsUpdate> goodsUpdateList);

    //批量删除goods
    int deleteAllGoodsById(List<Integer> goodsListId);

    //获取商品信息列表
    List<GoodsList> selectGoodsList(Goods goods);

    //通过商品id获取商品列表
    List<GoodsList> selectGoodsListByGoodsIdList(List<Integer> id);

    //通过结束时间删除goods
    int deleteAllGoodsByCouponEndTime(String couponEndTime);
}
