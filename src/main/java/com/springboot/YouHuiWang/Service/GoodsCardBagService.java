package com.springboot.YouHuiWang.Service;

import com.springboot.YouHuiWang.Pojo.GoodsCardBag;
import com.springboot.YouHuiWang.Pojo.GoodsCollection;
import com.springboot.YouHuiWang.Pojo.GoodsList;

import java.util.List;

public interface GoodsCardBagService {

    // 添加卡包
    public int insertCardBag(GoodsCardBag goodsCardBag);

    //删除卡包
    public int deleteCardBag(GoodsCardBag goodsCardBag);

    //查詢是否卡包
    public GoodsCardBag selectCardBag(GoodsCardBag goodsCardBag);

    //删除所有卡包
    public int deleteAllCardBag(Integer userId);

    //查询卡包
    public List<GoodsList> selectAllCardBag(Integer userId);

}
