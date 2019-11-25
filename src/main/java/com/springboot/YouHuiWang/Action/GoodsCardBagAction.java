package com.springboot.YouHuiWang.Action;

import com.opensymphony.xwork2.ModelDriven;
import com.springboot.YouHuiWang.Pojo.GoodsCardBag;
import com.springboot.YouHuiWang.Pojo.GoodsList;
import com.springboot.YouHuiWang.Service.GoodsCardBagService;
import com.springboot.YouHuiWang.Service.GoodsService;
import com.springboot.YouHuiWang.Util.CodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Api(tags = "商品卡包")
public class GoodsCardBagAction extends MyAction implements ModelDriven<GoodsCardBag> {

    private GoodsCardBag goodsCardBag = new GoodsCardBag();


    @Autowired
    private GoodsCardBagService goodsCardBagService;


    @PostMapping(value="goodsCardBag/addCardBag.action")
    @ApiOperation(value = "添加卡包",notes = "")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", dataType = "int", value = "用户ID", paramType = "query",required = true),
        @ApiImplicitParam(name = "goodsId", dataType = "int", value = "商品ID", paramType = "query",required = true)
    })
    public String addCardBag(){
        if (goodsCardBagService.insertCardBag(goodsCardBag)!=0){

             response.put("result", CodeUtil.success(null));

             return SUCCESS;
        }else{
            response.put("result",CodeUtil.error(-1,"添加卡包失败"));

            return SUCCESS;
        }
    }


    @PostMapping(value="goodsCardBag/deleteCardBag.action")
    @ApiOperation(value = "删除收藏",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", dataType = "int", value = "用户ID", paramType = "query",required = true),
            @ApiImplicitParam(name = "goodsId", dataType = "int", value = "商品ID", paramType = "query",required = true)
    })
    public String deleteCardBag(){
        if (goodsCardBagService.deleteCardBag(goodsCardBag) > 0){
            response.put("result", CodeUtil.success(null));
            return SUCCESS;
        }else{
            response.put("result",CodeUtil.error(-1,"删除卡包失败"));

            return SUCCESS;
        }
    }

    @PostMapping(value="goodsCardBag/isCardBag.action")
    @ApiOperation(value = "是否卡包存在",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", dataType = "int", value = "用户ID", paramType = "query",required = true),
            @ApiImplicitParam(name = "goodsId", dataType = "int", value = "商品ID", paramType = "query",required = true)
    })
    public String isCardBag(){
        System.out.println(goodsCardBag);
        GoodsCardBag goodsCardBagTemp = goodsCardBagService.selectCardBag(goodsCardBag);
        if (goodsCardBagTemp!= null && goodsCardBagTemp.getGoodsId()!=0 && goodsCardBagTemp.getUserId()!=0){

            response.put("result", CodeUtil.success(null));

            return SUCCESS;
        }else{
            response.put("result",CodeUtil.error(-1,"未收藏"));

            return SUCCESS;
        }
    }


    @GetMapping(value="goodsCardBag/myCardBag.action")
    @ApiOperation(value = "我的卡包",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", dataType = "int", value = "用户ID", paramType = "query"),
            @ApiImplicitParam(name = "goodsId", dataType = "int", value = "商品ID", paramType = "query")
    })
    public String myCardBag(){
        List<GoodsList> myCardBagGoodsList = goodsCardBagService.selectAllCardBag(goodsCardBag.getUserId());
        if (myCardBagGoodsList!=null){
            response.put("result", CodeUtil.success(myCardBagGoodsList));
        }else{
            response.put("result",CodeUtil.error(-1,"未查询到任何卡包商品"));
        }
        return SUCCESS;
    }



    public GoodsCardBag getGoodsCardBag() {
        return goodsCardBag;
    }

    public void setGoodsCardBag(GoodsCardBag goodsCardBag) {
        this.goodsCardBag = goodsCardBag;
    }


    public GoodsCardBagService getGoodsCardBagService() {
        return goodsCardBagService;
    }

    public void setGoodsCardBagService(GoodsCardBagService goodsCardBagService) {
        this.goodsCardBagService = goodsCardBagService;
    }



    @Override
    public GoodsCardBag getModel() {
        return goodsCardBag;
    }
}
