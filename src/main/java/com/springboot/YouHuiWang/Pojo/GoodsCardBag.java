package com.springboot.YouHuiWang.Pojo;

public class GoodsCardBag {

    private int userId;
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
