package com.springboot.YouHuiWang.Service.impl;

import com.springboot.YouHuiWang.Mapper.GoodsCardBagMapper;
import com.springboot.YouHuiWang.Mapper.GoodsMapper;
import com.springboot.YouHuiWang.Pojo.GoodsCardBag;
import com.springboot.YouHuiWang.Pojo.GoodsList;
import com.springboot.YouHuiWang.Service.GoodsCardBagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsCardBagServiceImpl implements GoodsCardBagService {

    @Autowired
    private GoodsCardBagMapper goodsCardBagMapper;


    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public int insertCardBag(GoodsCardBag goodsCardBag) {
        return goodsCardBagMapper.insertCardBag(goodsCardBag);
    }

    @Override
    public int deleteCardBag(GoodsCardBag goodsCardBag){
        return goodsCardBagMapper.deleteCardBag(goodsCardBag);
    }

    @Override
    public GoodsCardBag selectCardBag(GoodsCardBag goodsCardBag) {
        return goodsCardBagMapper.selectCardBag(goodsCardBag);
    }

    @Override
    public int deleteAllCardBag(Integer userId){
        return goodsCardBagMapper.deleteAllCardBag(userId);
    }

    @Override
    public List<GoodsList> selectAllCardBag(Integer userId){

        List<GoodsCardBag> goodsCardBags = goodsCardBagMapper.selectAllCardBag(userId);
        if (goodsCardBags!=null){
            //添加GoodsListId
            List<Integer> goodsIdList = new ArrayList<>();
            for (GoodsCardBag goodsCardBag: goodsCardBags){
                goodsIdList.add(goodsCardBag.getGoodsId());
            }

            //发给GoodsService查询商品
            List<GoodsList> myCardBagGoodsList = goodsMapper.selectGoodsListByGoodsIdList(goodsIdList);
            if (myCardBagGoodsList.size()!=0){
                return myCardBagGoodsList;
            }
        }
        return null;
    }
}
