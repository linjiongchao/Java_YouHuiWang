package com.springboot.YouHuiWang.Pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import org.springframework.stereotype.Component;

import java.util.List;


public class GoodsUpdate {
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
     * 折扣力度
     */
    private Float discounts;

    /**
     * 佣金类型，0-通用，1-定向，2-高佣，3-营销计划
     */
    @TableField("commissionType")
    private Integer commissionType;
    /**
     * 佣金比例
     */
    @TableField("commissionRate")
    private Float commissionRate;

    /**
     * 领券量
     */
    @TableField("couponReceiveNum")
    private Integer couponReceiveNum;

    /**
     * 30天销量
     */
    @TableField("monthSales")
    private Integer monthSales;
    /**
     * 2小时销量
     */
    @TableField("twoHoursSales")
    private Integer twoHoursSales;
    /**
     * 当日销量
     */
    @TableField("dailySales")
    private Integer dailySales;

    /**
     * 热推值
     */
    @TableField("hotPush")
    private Integer hotPush;

    /**
     * 商品在大淘客的二级分类id，该分类为前端分类，一个商品可能有多个二级分类id
     */
    private List subcid;


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

    public Float getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Float discounts) {
        this.discounts = discounts;
    }

    public Integer getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(Integer commissionType) {
        this.commissionType = commissionType;
    }

    public Float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Integer getCouponReceiveNum() {
        return couponReceiveNum;
    }

    public void setCouponReceiveNum(Integer couponReceiveNum) {
        this.couponReceiveNum = couponReceiveNum;
    }

    public Integer getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(Integer monthSales) {
        this.monthSales = monthSales;
    }

    public Integer getTwoHoursSales() {
        return twoHoursSales;
    }

    public void setTwoHoursSales(Integer twoHoursSales) {
        this.twoHoursSales = twoHoursSales;
    }

    public Integer getDailySales() {
        return dailySales;
    }

    public void setDailySales(Integer dailySales) {
        this.dailySales = dailySales;
    }

    public Integer getHotPush() {
        return hotPush;
    }

    public void setHotPush(Integer hotPush) {
        this.hotPush = hotPush;
    }

    public List getSubcid() {
        return subcid;
    }

    public void setSubcid(List subcid) {
        this.subcid = subcid;
    }

    @Override
    public String toString() {
        return "GoodsUpdate{" +
                "id=" + id +
                ", goodsId='" + goodsId + '\'' +
                ", originalPrice=" + originalPrice +
                ", actualPrice=" + actualPrice +
                ", couponPrice=" + couponPrice +
                ", discounts=" + discounts +
                ", commissionType=" + commissionType +
                ", commissionRate=" + commissionRate +
                ", couponReceiveNum=" + couponReceiveNum +
                ", monthSales=" + monthSales +
                ", twoHoursSales=" + twoHoursSales +
                ", dailySales=" + dailySales +
                ", hotPush=" + hotPush +
                ", subcid=" + subcid +
                '}';
    }
}
