package com.IsoftStone.effective.ch02;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 错误示例 避免创建不必要的对象
 * isBabyBoomer 调用会新建一个Calendar，一个timezone 和2 个Date
 * Created by Administrator on 2014/7/24.
 */
public class Person {
    private final Date birthDate = null;

    public boolean isBabyBoomer(){
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }
}
