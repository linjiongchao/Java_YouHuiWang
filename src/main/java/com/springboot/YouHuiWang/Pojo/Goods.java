package com.springboot.YouHuiWang.Pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Lin
 * @since 2019-10-14
 */

public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 商品淘宝链接
     */
    @TableField("itemLink")
    private String itemLink;
    /**
     * 淘宝标题
     */
    private String title;
    /**
     * 大淘客短标题
     */
    private String dtitle;
    /**
     * 推广文案
     */
    private String desc;
    /**
     * 商品在大淘客的分类id
     */
    private Integer cid;
    /**
     * 商品在大淘客的二级分类id，该分类为前端分类detailPics，一个商品可能有多个二级分类id
     */
    private List subcid;
    /**
     * 商品在淘宝的分类id
     */
    private Integer tbcid;
    /**
     * 商品主图链接
     */
    @TableField("mainPic")
    private String mainPic;
    /**
     * 营销主图链接
     */
    @TableField("marketingMainPic")
    private String marketingMainPic;
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
     * 优惠券链接
     */
    @TableField("couponLink")
    private String couponLink;
    /**
     * 券总量
     */
    @TableField("couponTotalNum")
    private Integer couponTotalNum;
    /**
     * 领券量
     */
    @TableField("couponReceiveNum")
    private Integer couponReceiveNum;
    /**
     * 优惠券结束时间
     */
    @TableField("couponEndTime")
    private String couponEndTime;
    /**
     * 优惠券开始时间
     */
    @TableField("couponStartTime")
    private String couponStartTime;
    /**
     * 优惠券金额
     */
    @TableField("couponPrice")
    private Float couponPrice;
    /**
     * 优惠券使用条件
     */
    @TableField("couponConditions")
    private Float couponConditions;
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
     * 是否是品牌商品
     */
    private Integer brand;
    /**
     * 品牌id
     */
    @TableField("brandId")
    private Integer brandId;
    /**
     * 品牌名称
     */
    @TableField("brandName")
    private String brandName;
    /**
     * 商品上架时间
     */
    @TableField("createTime")
    private String createTime;
    /**
     * 是否天猫超市商品，1-天猫超市商品，0-非天猫超市商品
     */
    private Integer tchaoshi;
    /**
     * 活动类型，1-无活动，2-淘抢购，3-聚划算
     */
    @TableField("activityType")
    private Integer activityType;
    /**
     * 活动开始时间
     */
    @TableField("activityStartTime")
    private String activityStartTime;
    /**
     * 活动结束时间
     */
    @TableField("activityEndTime")
    private String activityEndTime;
    /**
     * 店铺类型，1-天猫，0-淘宝
     */
    @TableField("shopType")
    private Integer shopType;
    /**
     * 是否海淘，1-海淘商品，0-非海淘商品
     */
    private Integer haitao;
    /**
     * 是否金牌卖家，1-金牌卖家，0-非金牌卖家
     */
    @TableField("goldSellers")
    private Integer goldSellers;
    /**
     * 淘宝卖家id
     */
    @TableField("sellerId")
    private String sellerId;
    /**
     * 店铺名称
     */
    @TableField("shopName")
    private String shopName;
    /**
     * 淘宝店铺等级
     */
    @TableField("shopLevel")
    private Integer shopLevel;
    /**
     * 描述分
     */
    @TableField("descScore")
    private Float descScore;
    /**
     * 描述相符
     */
    @TableField("dsrScore")
    private Float dsrScore;
    /**
     * 描述同行比
     */
    @TableField("dsrPercent")
    private Float dsrPercent;
    /**
     * 服务态度
     */
    @TableField("shipScore")
    private Float shipScore;
    /**
     * 物流服务
     */
    @TableField("serviceScore")
    private Float serviceScore;
    /**
     * 物流同行比
     */
    @TableField("servicePercent")
    private Float servicePercent;
    /**
     * 热推值
     */
    @TableField("hotPush")
    private Integer hotPush;
    /**
     * 放单人名称
     */
    @TableField("teamName")
    private Integer teamName;
    /**
     * 服务同行比
     */
    @TableField("shipPercent")
    private Float shipPercent;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getItemLink() {
        return itemLink;
    }

    public void setItemLink(String itemLink) {
        this.itemLink = itemLink;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public List getSubcid() {
        return subcid;
    }

    public void setSubcid(List subcid) {
        this.subcid = subcid;
    }

    public Integer getTbcid() {
        return tbcid;
    }

    public void setTbcid(Integer tbcid) {
        this.tbcid = tbcid;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public String getMarketingMainPic() {
        return marketingMainPic;
    }

    public void setMarketingMainPic(String marketingMainPic) {
        this.marketingMainPic = marketingMainPic;
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

    public String getCouponLink() {
        return couponLink;
    }

    public void setCouponLink(String couponLink) {
        this.couponLink = couponLink;
    }

    public Integer getCouponTotalNum() {
        return couponTotalNum;
    }

    public void setCouponTotalNum(Integer couponTotalNum) {
        this.couponTotalNum = couponTotalNum;
    }

    public Integer getCouponReceiveNum() {
        return couponReceiveNum;
    }

    public void setCouponReceiveNum(Integer couponReceiveNum) {
        this.couponReceiveNum = couponReceiveNum;
    }

    public String getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(String couponEndTime) {
        this.couponEndTime = couponEndTime;
    }

    public String getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(String couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public Float getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(Float couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Float getCouponConditions() {
        return couponConditions;
    }

    public void setCouponConditions(Float couponConditions) {
        this.couponConditions = couponConditions;
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

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getTchaoshi() {
        return tchaoshi;
    }

    public void setTchaoshi(Integer tchaoshi) {
        this.tchaoshi = tchaoshi;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(String activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public String getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(String activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public Integer getHaitao() {
        return haitao;
    }

    public void setHaitao(Integer haitao) {
        this.haitao = haitao;
    }

    public Integer getGoldSellers() {
        return goldSellers;
    }

    public void setGoldSellers(Integer goldSellers) {
        this.goldSellers = goldSellers;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getShopLevel() {
        return shopLevel;
    }

    public void setShopLevel(Integer shopLevel) {
        this.shopLevel = shopLevel;
    }

    public Float getDescScore() {
        return descScore;
    }

    public void setDescScore(Float descScore) {
        this.descScore = descScore;
    }

    public Float getDsrScore() {
        return dsrScore;
    }

    public void setDsrScore(Float dsrScore) {
        this.dsrScore = dsrScore;
    }

    public Float getDsrPercent() {
        return dsrPercent;
    }

    public void setDsrPercent(Float dsrPercent) {
        this.dsrPercent = dsrPercent;
    }

    public Float getShipScore() {
        return shipScore;
    }

    public void setShipScore(Float shipScore) {
        this.shipScore = shipScore;
    }

    public Float getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(Float serviceScore) {
        this.serviceScore = serviceScore;
    }

    public Float getServicePercent() {
        return servicePercent;
    }

    public void setServicePercent(Float servicePercent) {
        this.servicePercent = servicePercent;
    }

    public Integer getHotPush() {
        return hotPush;
    }

    public void setHotPush(Integer hotPush) {
        this.hotPush = hotPush;
    }

    public Integer getTeamName() {
        return teamName;
    }

    public void setTeamName(Integer teamName) {
        this.teamName = teamName;
    }

    public Float getShipPercent() {
        return shipPercent;
    }

    public void setShipPercent(Float shipPercent) {
        this.shipPercent = shipPercent;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsId='" + goodsId + '\'' +
                ", itemLink='" + itemLink + '\'' +
                ", title='" + title + '\'' +
                ", dtitle='" + dtitle + '\'' +
                ", desc='" + desc + '\'' +
                ", cid=" + cid +
                ", subcid=" + subcid +
                ", tbcid=" + tbcid +
                ", mainPic='" + mainPic + '\'' +
                ", marketingMainPic='" + marketingMainPic + '\'' +
                ", originalPrice=" + originalPrice +
                ", actualPrice=" + actualPrice +
                ", discounts=" + discounts +
                ", commissionType=" + commissionType +
                ", commissionRate=" + commissionRate +
                ", couponLink='" + couponLink + '\'' +
                ", couponTotalNum=" + couponTotalNum +
                ", couponReceiveNum=" + couponReceiveNum +
                ", couponEndTime='" + couponEndTime + '\'' +
                ", couponStartTime='" + couponStartTime + '\'' +
                ", couponPrice=" + couponPrice +
                ", couponConditions=" + couponConditions +
                ", monthSales=" + monthSales +
                ", twoHoursSales=" + twoHoursSales +
                ", dailySales=" + dailySales +
                ", brand=" + brand +
                ", brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", tchaoshi=" + tchaoshi +
                ", activityType=" + activityType +
                ", activityStartTime='" + activityStartTime + '\'' +
                ", activityEndTime='" + activityEndTime + '\'' +
                ", shopType=" + shopType +
                ", haitao=" + haitao +
                ", goldSellers=" + goldSellers +
                ", sellerId='" + sellerId + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopLevel=" + shopLevel +
                ", descScore=" + descScore +
                ", dsrScore=" + dsrScore +
                ", dsrPercent=" + dsrPercent +
                ", shipScore=" + shipScore +
                ", serviceScore=" + serviceScore +
                ", servicePercent=" + servicePercent +
                ", hotPush=" + hotPush +
                ", teamName=" + teamName +
                ", shipPercent=" + shipPercent +
                '}';
    }
}
