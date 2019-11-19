package com.springboot.YouHuiWang.Service;

import com.springboot.YouHuiWang.Pojo.Goods;
import com.baomidou.mybatisplus.service.IService;
import com.springboot.YouHuiWang.Pojo.GoodsDetails;
import com.springboot.YouHuiWang.Pojo.GoodsList;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lin
 * @since 2019-10-14
 */
public interface GoodsService extends IService<Goods> {

    int getGoodsListToDB();

    int updateGoodsListToDB();

    int pullGoodsByTimeToDB(String startTime);

    int getStaleGoodsByTimeToDB(String startTime);

    List<GoodsList> selectGoodsList(Goods goods);

    GoodsDetails getGoodsDetailsById(int id);

    //通过结束时间删除goods
    int deleteAllGoodsByCouponEndTime(String couponEndTime);

}
