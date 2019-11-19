package com.springboot.YouHuiWang.Service;

import com.springboot.YouHuiWang.Pojo.GoodsCollection;
import com.springboot.YouHuiWang.Pojo.GoodsList;

import java.util.List;

public interface GoodsCollectionService {

    // 添加收藏
    public int insertCollection(GoodsCollection goodsCollection);

    //删除收藏
    public int deleteCollection(GoodsCollection goodsCollection);

    //查詢是否收藏
    public GoodsCollection selectCollection(GoodsCollection goodsCollection);

    //删除所有收藏
    public int deleteAllCollection(Integer userId);

    //查询收藏
    public List<GoodsList> selectAllCollection(Integer userId);

}
