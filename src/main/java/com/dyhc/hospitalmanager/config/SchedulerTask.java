package com.dyhc.hospitalmanager.config;

import com.dyhc.hospitalmanager.dao.RedisDao;
import com.dyhc.hospitalmanager.util.GetFetureDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@Component
@EnableScheduling
public class SchedulerTask {
    @Autowired
    RedisDao redisDao;

    public void start() throws InterruptedException {
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result=format.format(date);
        redisDao.delete(result);
        String newKey= GetFetureDate.getFetureDate(8);
        redisDao.setKey(newKey,"50");
    }
}
