package com.springboot.YouHuiWang.Service.impl;

import com.springboot.YouHuiWang.Mapper.GoodsCollectionMapper;
import com.springboot.YouHuiWang.Mapper.GoodsMapper;
import com.springboot.YouHuiWang.Pojo.GoodsCollection;
import com.springboot.YouHuiWang.Pojo.GoodsList;
import com.springboot.YouHuiWang.Service.GoodsCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsCollectionServiceImpl implements GoodsCollectionService {

    @Autowired
    private GoodsCollectionMapper goodsCollectionMapper;


    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public int insertCollection(GoodsCollection goodsCollection) {
        return goodsCollectionMapper.insertCollection(goodsCollection);
    }

    @Override
    public int deleteCollection(GoodsCollection goodsCollection){
        return goodsCollectionMapper.deleteCollection(goodsCollection);
    }

    @Override
    public GoodsCollection selectCollection(GoodsCollection goodsCollection) {
        return goodsCollectionMapper.selectCollection(goodsCollection);
    }

    @Override
    public int deleteAllCollection(Integer userId){
        return goodsCollectionMapper.deleteAllCollection(userId);
    }

    @Override
    public List<GoodsList> selectAllCollection(Integer userId){

        List<GoodsCollection> goodsCollections = goodsCollectionMapper.selectAllCollection(userId);
        if (goodsCollections!=null){
            //添加GoodsListId
            List<Integer> goodsIdList = new ArrayList<>();
            for (GoodsCollection goodsCollection: goodsCollections){
                goodsIdList.add(goodsCollection.getGoodsId());
            }

            //发给GoodsService查询商品
            List<GoodsList> myCollectionGoodsList = goodsMapper.selectGoodsListByGoodsIdList(goodsIdList);
            if (myCollectionGoodsList.size()!=0){
                return myCollectionGoodsList;
            }
        }
        return null;
    }
}
