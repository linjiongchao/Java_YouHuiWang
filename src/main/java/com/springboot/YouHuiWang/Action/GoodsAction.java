package com.springboot.YouHuiWang.Action;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opensymphony.xwork2.ModelDriven;
import com.springboot.YouHuiWang.Pojo.Goods;
import com.springboot.YouHuiWang.Pojo.GoodsDetails;
import com.springboot.YouHuiWang.Pojo.GoodsList;
import com.springboot.YouHuiWang.Service.GoodsService;
import com.springboot.YouHuiWang.Util.CodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Lin
 * @since 2019-10-14
 */

@Controller
@Api(value = "商品控制类")
public class GoodsAction extends MyAction implements ModelDriven<Goods> {



    private Goods goods = new Goods();

    private int pageNum = 1;

    private int pageSize = 10;

    @Autowired
    private GoodsService goodsService;


//    //SpringMVC @RequestMapping只是用来生成文档 无其他用处
//    @GetMapping(value="GoodsAction_getHelloWorld.action")
//    @ApiOperation(value = "获取HelloWorld",notes = "这里是消息的备注信息")
//    public String getHelloWorld(){
//        response.put("hello","HelloWorld");
//        return SUCCESS;
//    }


    @GetMapping(value="goods/selectGoodsList.action")
    @ApiOperation(value = "查询商品列表",notes = "通过Goods参数获取Goods列表")
    public String selectGoodsList() {

        PageHelper.startPage(pageNum,pageSize);

        List<GoodsList> goodsLists = goodsService.selectGoodsList(goods);

        PageInfo info = new PageInfo(goodsLists);


        response.put("result", CodeUtil.success(info));

        return SUCCESS;
    }

    @GetMapping(value="goods/getGoodsDetailById.action")
    @ApiOperation(value = "查询商品单品信息",notes = "通过Goods中的Id获取商品详细信息")
    public String getGoodsDetailById(){

        if (goods.getId()==null || goods.getId().toString().length()!=8){
            response.put("result", CodeUtil.error(-1,"商品Id错误"));
        }else{
            GoodsDetails goodsDetails =  goodsService.getGoodsDetailsById(goods.getId());
            response.put("result", CodeUtil.success(goodsDetails));
        }
        return SUCCESS;
    }


    @Override
    public Goods getModel() {
        return goods;
    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

