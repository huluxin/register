package com.IsoftStone.harvest.from4GPOS;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-7-2
 * Time: 上午10:53
 * To change this template use File | Settings | File Templates.
 */
public class CalendarUtil {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Calendar calendar = Calendar.getInstance();
        System.out.println("Current Date = " + calendar.getTime());
        System.out.println("Current Day of Week Name = " + calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.CHINA));
        System.out.println("Current Day of Week Name = " + calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.ENGLISH));
        System.out.println("Current Day of Week Name = " + calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
        System.out.println("Current Hour = " + calendar.get(Calendar.HOUR));
        System.out.println("Current Day = " + calendar.get(Calendar.DATE));
        System.out.println("Current Hour of Day = " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Current Day of Week = " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Current Day of Month = " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Current Day of Year = " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Current Month = " + calendar.get(Calendar.MONTH));
        System.out.println("当月最后一天: " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.MONTH, 1);        //6月
        System.out.println("Current Date = " + calendar.getTime());
        System.out.println("6月最后一天: " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.MONTH, 1);        //下个月
        System.out.println("Current Date = " + calendar.getTime());
        System.out.println("7月第一天: " + calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out.println("7月最后一天: " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    }
}
