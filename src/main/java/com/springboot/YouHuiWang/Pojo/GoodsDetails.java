package com.springboot.YouHuiWang.Pojo;

import org.springframework.stereotype.Component;


public class GoodsDetails extends Goods {

    /**
     * 商品主图（需要做适配）
     */
                private String detailPics;

    /**
     * 淘宝轮播图
     */
    private String imgs;

    /**
     * 相关商品图
     */
    private String reimgs;


    public String getDetailPics() {
        return detailPics;
    }

    public void setDetailPics(String detailPics) {
        this.detailPics = detailPics;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getReimgs() {
        return reimgs;
    }

    public void setReimgs(String reimgs) {
        this.reimgs = reimgs;
    }

    @Override
    public String toString() {
        return "GoodsDetails{" +
                super.toString() +
                "detailPics=" + detailPics +
                ", imgs=" + imgs +
                ", reimgs=" + reimgs +
                '}';
    }
}
