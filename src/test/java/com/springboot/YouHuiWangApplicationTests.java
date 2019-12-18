package com.springboot;

import com.springboot.YouHuiWang.Mapper.CateGoryMapper;
import com.springboot.YouHuiWang.Mapper.GoodsMapper;
import com.springboot.YouHuiWang.Pojo.Goods;
import com.springboot.YouHuiWang.Pojo.GoodsList;
import com.springboot.YouHuiWang.Pojo.SuperCategory;
import com.springboot.YouHuiWang.Pojo.User;
import com.springboot.YouHuiWang.Service.*;
import com.springboot.YouHuiWang.Util.DaTaoKeApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableScheduling
@Slf4j
public class YouHuiWangApplicationTests {

    @Autowired
    SubCidTableService subCidTableService;


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsMapper goodsMapper;


    @Autowired
    private CateGoryMapper cateGoryMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SearchService searchService;



    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        subCidTableService.get();
    }

    @Test
    public void putGoodsInDB() {
        int totalSize = goodsService.getGoodsListToDB();
        System.out.println("total：" + totalSize);
    }

    @Test
    public void pullGoodsByTime() {
//        int totalSize = goodsService.pullGoodsByTimeToDB("2019-10-17 16:00:00");
//        System.out.println("total：" + totalSize);


        System.out.println(        DaTaoKeApi.pullGoodsByTime("1","2019-10-17 16:00:00"));

    }


    @Test
    public void getNewestGoods() {
        int totalSize = goodsService.updateGoodsListToDB();
        System.out.println("total：" + totalSize);
    }

    @Test
    public void getStaleGoodsByTime() {
        int total = goodsService.getStaleGoodsByTimeToDB("2019-10-17 00:00:00");
        System.out.println("total：" + total);
    }


    @Test
    public void getGoodsDetails() {
        goodsService.getGoodsDetailsById(225933481);
    }

    @Test
    public void getGoodsList() {

        System.out.println("getGoodsList:" + DaTaoKeApi.getGoodsList("1"));
    }


    @Test
    public void getSuperCategory() {

        int total = categoryService.insertCategory();
        System.out.println("插入数量：" + total);
    }


    @Test
    public void selectCateGory() {
        List<SuperCategory> superCategoryList = cateGoryMapper.selectSuperCateGory();
        System.out.println("superCategoryList:" + superCategoryList);
    }


    @Test
    public void searchSuggestion() {
        List<Map> searchSuggestion = searchService.getSearchSuggestion("裤子");
        System.out.println("searchSuggestion:" + searchSuggestion);
    }

    @Test
    public void hotSearch() {
        List hotSearch = searchService.getHotSearch();
        System.out.println("hotSearch:" + hotSearch);
    }


    @Test
    public void getPrivilegeLink() {
        String json = DaTaoKeApi.getPrivilegeLink("600528317790");
        System.out.println("getPrivilegeLink:" + json);

    }


    @Test
    public void insertUser(){
        User user = new User();
        user.setUserName("root");
        user.setUserPassword("admin");
        user.setPhone("15819586904");
        System.out.println( userService.insertUser(user));
    }

    @Test
    public void updateUserById() {
        User user = new User();
        user.setUserId(556962772);
        user.setUserName("root");
        user.setUserPassword("admin");
        user.setPhone("15819586904");
        System.out.println(userService.updateUserById(user));
    }


    @Test
    public void updateUserPasswordByNameAndPhone() {
        User user = new User();
        user.setUserName("root");
        user.setUserPassword("root");
        user.setPhone("15819586904");
        System.out.println(userService.updateUserPasswordByNameAndPhone(user));
    }

    @Test
    public void deleteAllGoodsByCouponEndTime(){
        String couponEndTime = "2019-11-13 23:59:59";
        int total = goodsService.deleteAllGoodsByCouponEndTime(couponEndTime);
        System.out.println("total：" + total);
    }


}
