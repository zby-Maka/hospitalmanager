package com.dyhc.hospitalmanager.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetFetureDate {
    /**
     * 获取七天后的日期
     * @param past
     * @return
     */
    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }
}
