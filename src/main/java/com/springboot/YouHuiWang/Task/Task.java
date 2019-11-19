package com.springboot.YouHuiWang.Task;

import ch.qos.logback.classic.Logger;
import com.springboot.YouHuiWang.Service.GoodsService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
@EnableScheduling
public class Task {

    @Autowired
    private GoodsService goodsService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    /**
     * 五分钟定时拉取一次
     */
    @Scheduled(initialDelay = 1000*10, fixedDelay = 1000 * 60 * 5)
    public void pullGoodsByTimeToDB() {

        //从当前的30分钟前
        long time = System.currentTimeMillis() - (1000 * 60 * 30);
        Date date = new Date(time);


        String startTime = simpleDateFormat.format(date);
        System.out.println("定时拉取更新开始时间:" + startTime);

        int totalSize = goodsService.pullGoodsByTimeToDB(startTime);

        System.out.println("定时拉取更新结束时间:" + simpleDateFormat.format(new Date()));
        System.out.println("定时拉取更新条数:" + totalSize);
    }

    /**
     * 五分钟定时删除一次
     */
    @Scheduled(initialDelay = 1000*10, fixedDelay = 1000 * 60 * 5)
    public void getStaleGoodsByTimeToDB() {

        //从当前的30分钟前
        long time = System.currentTimeMillis() - (1000 * 60 * 30);
        Date date = new Date(time);

        String startTime = simpleDateFormat.format(date);
        System.out.println("定时删除失效商品开始时间:" + startTime);

        int totalSize = goodsService.getStaleGoodsByTimeToDB(startTime);

        System.out.println("定时删除失效商品开始时间:" + simpleDateFormat.format(new Date()));
        System.out.println("删除条数:" + totalSize);
    }


    /**
     * 五分钟更新一次数据
     */
    @Scheduled(initialDelay = 1000*10, fixedDelay = 1000 * 60 * 5)
    public void updateGoodsListToDB() {

        //从当前的30分钟前
        long time = System.currentTimeMillis() - (1000 * 60 * 30);
        Date date = new Date(time);

        String startTime = simpleDateFormat.format(date);
        System.out.println("定时更新数据库商品开始时间:" + startTime);

        int totalSize = goodsService.updateGoodsListToDB();

        System.out.println("定时更新数据库商品开始时间:" + simpleDateFormat.format(new Date()));
        System.out.println("定时更新数据库条数:" + totalSize);
    }

    /**
     * 一小时更新一次
     */
    @Scheduled(initialDelay = 0, fixedDelay = 1000 * 60 * 60)
    public void deleteAllGoodsByCouponEndTime(){
        //从当前
        long time = System.currentTimeMillis() ;
        Date date = new Date(time);

        String startTime = simpleDateFormat.format(date);
        System.out.println("删除数据库失效商品开始时间:" + startTime);

//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.DAY_OF_MONTH, -1);
//        Date couponEndTimeDate = calendar.getTime();
//        System.out.println(simpleDateFormat.format(date));
        int totalSize = goodsService.deleteAllGoodsByCouponEndTime(startTime);

        System.out.println("删除数据库失效商品条数:" + simpleDateFormat.format(new Date()));
        System.out.println("删除数据库失效商品开始时间:" + totalSize);


    }

}
