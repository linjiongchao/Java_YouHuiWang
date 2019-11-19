package com.springboot.YouHuiWang.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.YouHuiWang.Pojo.GoodsCollection;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface GoodsCollectionMapper extends BaseMapper<GoodsCollection> {

    // 添加收藏
    public int insertCollection(GoodsCollection goodsCollection);

    //删除收藏
    public int deleteCollection(GoodsCollection goodsCollection);

    //查詢是否收藏
    public GoodsCollection selectCollection(GoodsCollection goodsCollection);

    //删除所有收藏
    public int deleteAllCollection(Integer userId);

    //查询收藏
    public List<GoodsCollection> selectAllCollection(Integer userId);

}
