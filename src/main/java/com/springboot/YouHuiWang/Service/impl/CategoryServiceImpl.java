package com.springboot.YouHuiWang.Service.impl;

import com.springboot.YouHuiWang.Mapper.CateGoryMapper;
import com.springboot.YouHuiWang.Pojo.SubCategories;
import com.springboot.YouHuiWang.Pojo.SuperCategory;
import com.springboot.YouHuiWang.Service.CategoryService;
import com.springboot.YouHuiWang.Util.CodeUtil;
import com.springboot.YouHuiWang.Util.DaTaoKeApi;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CateGoryMapper cateGoryMapper;


    /**
     * 插入一级分类 以及 二级分类
     *
     * @return
     */
    @Transactional
    @Override
    public int insertCategory() {
        String json = DaTaoKeApi.getSuperCategory();
        int total = 0;
        System.out.println(json);

        if (CodeUtil.isSuccessForDaTaoKe(json)) {

            List<SuperCategory> superCategoryList = new ArrayList<>();
            List<SubCategories> subCategoriesList = new ArrayList<>();

            JSONArray data = JSONObject.fromObject(json).getJSONArray("data");

            //遍历data数组
            for (Object temp : data) {

                JSONObject item = JSONObject.fromObject(temp);
                //获取每一项值
                int cid = item.getInt("cid");
                String cname = item.getString("cname");
                String cpic = item.getString("cpic");

                //构造一级分类
                SuperCategory superCategory = new SuperCategory(cid, cname, cpic);

                //数组添加一级分类
                superCategoryList.add(superCategory);

                //获取二级分类
                JSONArray subCategoriesArray = item.getJSONArray("subcategories");

                //遍历子数组
                for (Object subTemp : subCategoriesArray) {

                    JSONObject subItem = JSONObject.fromObject(subTemp);
                    //获取每一项值

                    long subcid = subItem.getLong("subcid");
                    String subcname = subItem.getString("subcname");
                    String scpic = subItem.getString("scpic");

                    //构造二级分类
                    SubCategories subCategories = new SubCategories(subcid, subcname, scpic, cid);

                    subCategoriesList.add(subCategories);

                }

            }


            if (superCategoryList.size() != 0) {
                total = total + cateGoryMapper.insertSuperCateGory(superCategoryList);
            }

            System.out.println(subCategoriesList);
            if (subCategoriesList.size() != 0) {
                total = total + cateGoryMapper.insertSubCateGory(subCategoriesList);
            }

        }

        return total;
    }

    /**
     * 查询一级分类以及二级分类
     *
     * @return
     */
    @Override
    public List<SuperCategory> selectSuperCateGory() {
        return cateGoryMapper.selectSuperCateGory();
    }


}
