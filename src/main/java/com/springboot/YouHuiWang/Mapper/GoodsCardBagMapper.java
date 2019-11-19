package com.springboot.YouHuiWang.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.YouHuiWang.Pojo.GoodsCardBag;
import com.springboot.YouHuiWang.Pojo.GoodsCardBag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsCardBagMapper extends BaseMapper<GoodsCardBag> {

    // 添加卡包
    public int insertCardBag(GoodsCardBag goodsCardBag);

    //删除卡包
    public int deleteCardBag(GoodsCardBag goodsCardBag);

    //查詢是否卡包
    public GoodsCardBag selectCardBag(GoodsCardBag goodsCardBag);

    //删除所有卡包
    public int deleteAllCardBag(Integer userId);

    //查询卡包
    public List<GoodsCardBag> selectAllCardBag(Integer userId);

}
