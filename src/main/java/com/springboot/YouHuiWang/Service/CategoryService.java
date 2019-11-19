package com.springboot.YouHuiWang.Service;

import com.springboot.YouHuiWang.Pojo.SuperCategory;

import java.util.List;

public interface CategoryService {

    //插入一级分类 以及 二级分类
    public int insertCategory();

    //查询一级分类以及二级分类
    public List<SuperCategory> selectSuperCateGory();
}
