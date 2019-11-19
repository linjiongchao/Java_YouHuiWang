package com.springboot.YouHuiWang.Pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import org.springframework.stereotype.Component;


public class GoodsList {

    /**
     * 商品id
     */
    @TableField("id")
    private Integer id;

    /**
     * 淘宝商品id
     */
    @TableField("goodsId")
    private String goodsId;

    /**
     * 淘宝标题
     */
    private String title;
    /**
     * 大淘客短标题
     */
    private String dtitle;

    /**
     * 商品主图链接
     */
    @TableField("mainPic")
    private String mainPic;

    /**
     * 商品原价
     */
    @TableField("originalPrice")
    private Float originalPrice;
    /**
     * 券后价
     */
    @TableField("actualPrice")
    private Float actualPrice;

    /**
     * 优惠券金额
     */
    @TableField("couponPrice")
    private Float couponPrice;

    /**
     * 30天销量
     */
    @TableField("monthSales")
    private Integer monthSales;

    /**
     * 店铺类型，1-天猫，0-淘宝
     */
    @TableField("shopType")
    private Integer shopType;


    /**
     * 是否是品牌商品
     */
    private Integer brand;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDtitle() {
        return dtitle;
    }

    public void setDtitle(String dtitle) {
        this.dtitle = dtitle;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public Float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Float getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Float actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Float getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(Float couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Integer getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(Integer monthSales) {
        this.monthSales = monthSales;
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "GoodsList{" +
                "id=" + id +
                ", goodsId='" + goodsId + '\'' +
                ", title='" + title + '\'' +
                ", dtitle='" + dtitle + '\'' +
                ", mainPic='" + mainPic + '\'' +
                ", originalPrice=" + originalPrice +
                ", actualPrice=" + actualPrice +
                ", couponPrice=" + couponPrice +
                ", monthSales=" + monthSales +
                ", shopType=" + shopType +
                ", brand=" + brand +
                '}';
    }
}
