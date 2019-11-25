package com.springboot.YouHuiWang.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.springboot.YouHuiWang.Pojo.SuperCategory;
import com.springboot.YouHuiWang.Service.CategoryService;
import com.springboot.YouHuiWang.Util.CodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Api(tags = "超级分类")
public class CategoryAction extends MyAction implements ModelDriven<SuperCategory> {



    @Autowired
    private CategoryService categoryService;

    List<SuperCategory> superCategory;


    @GetMapping(value="category/selectSuperCateGory.action")
    @ApiOperation(value = "查询超级分类",notes = "查询超级分类")
    public String selectSuperCateGory(){

        //第一次获取为null时 从数据库中获取
        if (superCategory ==null) {
            superCategory = categoryService.selectSuperCateGory();
        }
        //当不为空时 直接返回
        if (superCategory!=null) {
            response.put("result", CodeUtil.success(superCategory));
        }else{
            response.put("result", CodeUtil.error(-1,"分类获取错误"));
        }

       return SUCCESS;

    }


    @Override
    public SuperCategory getModel() {
        return null;
    }
}
