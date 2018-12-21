package cn.xykoo.agent.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 随机数工具类
 *
 * @author : J.Tang
 * @version : v1.0
 * @email : seven_tjb@163.com
 * @date : 2018-10-29
 **/

public class RandomUtil {

    private static Random random = new Random();

    /**
     * 生成会员卡号
     *
     * @param cardType 会员卡类型
     * @return 会员卡号
     */
    public static String getMembershipCardNo(Integer cardType) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date = new Date();

        String number = String.valueOf(date.getTime());

        String strDate = simpleDateFormat.format(date);

        String typeNumber = String.valueOf(cardType);

        if (cardType < 10) {
            typeNumber = String.format("%s%s", typeNumber, "0");
        }
        return String.format("%s%s%s", strDate, typeNumber, number);
    }

    public static int getNextInt(int start, int end) {

        int minNumber = random.nextInt(end-start);

        return minNumber + start;

    }

    public static int getNextInt(int end) {

        return random.nextInt(end);
    }
}
