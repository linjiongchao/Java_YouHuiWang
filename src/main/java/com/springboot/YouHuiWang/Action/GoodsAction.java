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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
@Api(tags = "商品")
public class GoodsAction extends MyAction implements ModelDriven<Goods> {



    private Goods goods = new Goods();

    private int pageNum = 1;

    private int pageSize = 10;

    @Autowired
    private GoodsService goodsService;

    //springboot+struts2 默认请求被struts2拦截 无法开启文档  需要使用SpringMvc注解帮助开启文档
    @GetMapping(value="goods/selectGoodsList.action")

    @ApiOperation(value = "查询商品列表",notes = "通过Goods参数获取Goods列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "int", defaultValue = "1", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "int", defaultValue = "20", paramType = "query"),
            @ApiImplicitParam(name = "id", value = "商品ID", dataType = "id", paramType = "query"),
            @ApiImplicitParam(name = "sellerId", value = "店铺ID", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "cid", value = "一级分类", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "subcid", value = "二级分类", dataType = "list", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "标题", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "actualPrice", value = "卷后价排序 -1:降序 0:升序", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "monthSales", value = "月销量排序 -1:降序 0:升序", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "dailySales", value = "日销量排序 -1:降序 0:升序", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "twoHoursSales", value = "两小时销量排序 -1:降序 0:升序", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "couponReceiveNum", value = "人气 领券量排序 -1:降序 0:升序", dataType = "int", paramType = "query"),
    })
    public String selectGoodsList() {

        PageHelper.startPage(pageNum,pageSize);

        List<GoodsList> goodsLists = goodsService.selectGoodsList(goods);

        PageInfo info = new PageInfo(goodsLists);


        response.put("result", CodeUtil.success(info));

        return SUCCESS;
    }

    @GetMapping(value="goods/getGoodsDetailById.action")
    @ApiOperation(value = "查询商品单品信息",notes = "通过Goods中的Id获取商品详细信息")
    @ApiImplicitParam(name = "id", value = "商品ID", dataType = "int", paramType = "query")
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

