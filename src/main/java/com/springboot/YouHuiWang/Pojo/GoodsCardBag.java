package com.springboot.YouHuiWang.Pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="GoodsCardBag",description="卡包")
public class GoodsCardBag {

    @ApiModelProperty(value="用户ID")
    private int userId;
    @ApiModelProperty(value="商品ID")
    private int goodsId;

    public GoodsCardBag() {
    }

    public GoodsCardBag(int userId, int goodsId) {
        this.userId = userId;
        this.goodsId = goodsId;
    }

    public int getUserId() {
        return userId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }


    @Override
    public String toString() {
        return "Collection{" +
                "userId=" + userId +
                ", goodsId=" + goodsId +
                '}';
    }
}
