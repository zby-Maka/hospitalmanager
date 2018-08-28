package com.dyhc.hospitalmanager.config;

import com.dyhc.hospitalmanager.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Configuration
@Component
@EnableScheduling
public class SchedulerTask {
    @Autowired
    RedisDao redisDao;

    public void start() throws InterruptedException {
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String result=format.format(date);
        redisDao.delete(result);
        String newKey=getFetureDate(7);
        redisDao.setKey(newKey,"50");
    }

    /**
     * 获取七天后的日期
     * @param past
     * @return
     */
    public String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String result = format.format(today);
        return result;
    }
}
