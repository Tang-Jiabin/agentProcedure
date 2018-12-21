package cn.xykoo.agent.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具
 *
 * @author : J.Tang
 * @version : v1.0
 * @email : seven_tjb@163.com
 * @date : 2018-10-29
 **/

public class DateUtil {


    public static Date getSpecifiedDate(Date date, int days) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //增加天数，负数则为减少天数
        calendar.add(Calendar.DATE, days);
        date = calendar.getTime();
        return date;

    }


    public static String getTodayFormat(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    public static String getFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date getTodayZeroHours() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        System.out.println(getFormat(getSpecifiedDate(getTodayZeroHours(),1), "yyyy-MM-dd HH:mm:ss"));
    }

}
