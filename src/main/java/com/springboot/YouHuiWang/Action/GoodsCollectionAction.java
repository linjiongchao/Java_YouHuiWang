package com.springboot.YouHuiWang.Action;

import com.opensymphony.xwork2.ModelDriven;
import com.springboot.YouHuiWang.Pojo.GoodsCollection;
import com.springboot.YouHuiWang.Pojo.GoodsList;
import com.springboot.YouHuiWang.Service.GoodsCollectionService;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@Api(tags = "商品收藏")
public class GoodsCollectionAction extends MyAction implements ModelDriven<GoodsCollection> {

    private GoodsCollection goodsCollection = new GoodsCollection();


    @Autowired
    private GoodsCollectionService goodsCollectionService;

    @Autowired
    private GoodsService goodsService;

    @PostMapping(value="goodsCollection/addCollection.action")
    @ApiOperation(value = "添加收藏",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", dataType = "int", value = "用户ID", paramType = "query",required = true),
            @ApiImplicitParam(name = "goodsId", dataType = "int", value = "商品ID", paramType = "query",required = true)
    })
    public String addCollection(){
        if (goodsCollectionService.insertCollection(goodsCollection)!=0){

             response.put("result", CodeUtil.success(null));

             return SUCCESS;
        }else{
            response.put("result",CodeUtil.error(-1,"添加收藏失败"));

            return SUCCESS;
        }
    }


    @PostMapping(value="goodsCollection/deleteCollection.action")
    @ApiOperation(value = "删除收藏",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", dataType = "int", value = "用户ID", paramType = "query",required = true),
            @ApiImplicitParam(name = "goodsId", dataType = "int", value = "商品ID", paramType = "query",required = true)
    })
    public String deleteCollection(){
        if (goodsCollectionService.deleteCollection(goodsCollection) > 0){
            response.put("result", CodeUtil.success(null));
            return SUCCESS;
        }else{
            response.put("result",CodeUtil.error(-1,"删除收藏失败"));

            return SUCCESS;
        }
    }

    @PostMapping(value="goodsCollection/isCollection.action")
    @ApiOperation(value = "是否收藏",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", dataType = "int", value = "用户ID", paramType = "query",required = true),
            @ApiImplicitParam(name = "goodsId", dataType = "int", value = "商品ID", paramType = "query",required = true)
    })
    public String isCollection(){
        System.out.println(goodsCollection);
        GoodsCollection goodsCollectionTemp = goodsCollectionService.selectCollection(goodsCollection);
        if (goodsCollectionTemp!= null && goodsCollectionTemp.getGoodsId()!=0 && goodsCollectionTemp.getUserId()!=0){

            response.put("result", CodeUtil.success(null));

            return SUCCESS;
        }else{
            response.put("result",CodeUtil.error(-1,"未收藏"));

            return SUCCESS;
        }
    }


    @GetMapping(value="goodsCollection/myCollection.action")
    @ApiOperation(value = "我的收藏",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", dataType = "int", value = "用户ID", paramType = "query",required = true),
    })
    public String myCollection(){
        List<GoodsList> myCollectionGoodsList = goodsCollectionService.selectAllCollection(goodsCollection.getUserId());
        System.out.println("myCollectionGoodsList：" + myCollectionGoodsList);
        if (myCollectionGoodsList!=null){
            response.put("result", CodeUtil.success(myCollectionGoodsList));
        }else{
            response.put("result",CodeUtil.error(-1,"未查询到任何收藏商品"));
        }
        return SUCCESS;
    }



    public GoodsCollection getGoodsCollection() {
        return goodsCollection;
    }

    public void setGoodsCollection(GoodsCollection goodsCollection) {
        this.goodsCollection = goodsCollection;
    }


    public GoodsCollectionService getGoodsCollectionService() {
        return goodsCollectionService;
    }

    public void setGoodsCollectionService(GoodsCollectionService goodsCollectionService) {
        this.goodsCollectionService = goodsCollectionService;
    }



    @Override
    public GoodsCollection getModel() {
        return goodsCollection;
    }
}
