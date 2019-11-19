package com.springboot.YouHuiWang.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.YouHuiWang.Pojo.Goods;
import com.springboot.YouHuiWang.Pojo.SubCategories;
import com.springboot.YouHuiWang.Pojo.SuperCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CateGoryMapper extends BaseMapper<SuperCategory> {

    //批量插入一級分类
    public int insertSuperCateGory(List<SuperCategory> superCatGory);


    //批量插入二級分类
    public int insertSubCateGory(List<SubCategories> subCatGory);

    //查询超级分类
    public List<SuperCategory> selectSuperCateGory();


}
