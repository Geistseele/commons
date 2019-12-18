package com.kcmpts.commons.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author klauszong
 */
@SuppressWarnings("unused")
public class DateTools {
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     *当天日期 = 2016-09-26
     */
    public static String getServerToday() {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        Date date = Calendar.getInstance().getTime();
        return sdf.format(date);
    }

    public static String getServerTodayTime() {
        SimpleDateFormat sdf_m = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Calendar c = Calendar.getInstance();
        String str = sdf_m.format(c.getTime());
        return str;
    }

    /**
     * 昨天日期 = yyyy-MM-dd
     * @return
     */
    public static String getServerTodayBefore() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String yesterday = new SimpleDateFormat(YYYY_MM_DD).format(cal.getTime());
        return yesterday;
    }

    /**
     * 当天时间 = yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getServerDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Date date = Calendar.getInstance().getTime();
        return sdf.format(date);
    }

    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 格式化  开始 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

    /**
     * 格式化Date对象输出字符串的函数
     *
     * @param date   日期
     * @param format 格式
     * @return String 为date按指定格式format格式化的string串
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String formatDateFull(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return sdf.format(date);
    }

    /**
     * 以指定的格式和日期字符返回日期
     *
     * @param str    String 需要格式化的日期串
     * @param format String 输出格式
     * @return String String 为按指定格式format格式化的Date
     */
    public static Date formatDate(String str, String format) {
        return stringToDate(str, format);
    }

    /**
     * 以指定的格式和日期字符返回日期
     *
     * @param str    String 需要格式化的日期串
     * @param format String 输出格式
     * @return Date 为按指定格式format格式化的Date,失败返回null
     */
    public static Date stringToDate(String str, String format) {
        if (str != null) {
            DateFormat dateFormat = new SimpleDateFormat(format);
            try {
                return dateFormat.parse(str);
            } catch (ParseException e) {
                return null;
            }
        }

        return null;
    }

    /**
     * 把Date类型转换为Timestamp
     *
     * @param date Date 需要被转换的Date类型日期
     * @return Timestamp类型日期
     */
    public static Timestamp dateToTimestamp(Date date) {
        Timestamp tmResult = null;
        if (date != null) {
            tmResult = new Timestamp(date.getTime());
        }
        return tmResult;
    }
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 比 较 ■■■■■■■■■■■■■■■■■■■■■■■■■■
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

    /**
     * 判断"YYYY_MM_DD"格式日期字符串是否为今天
     *
     * @param checkDate String "YYYY_MM_DD"格式的日期字符串
     * @return 若checkDate为今天，则返回true否者为false
     */
    public static boolean isToday(String checkDate) {
        Date date = DateTools.stringToDate(checkDate, YYYY_MM_DD);
        DateTools.formatDate(date, YYYY_MM_DD);
        return DateTools.formatDate(new Date(), YYYY_MM_DD).equals(
                DateTools.formatDate(date, YYYY_MM_DD));
    }

    /**
     * earlier 早于当前时间
     * @param checkDate
     * @return
     */
    public static boolean isEarlier(Date checkDate) {
        Calendar now = Calendar.getInstance();
        return now.getTimeInMillis() - checkDate.getTime() < 0 ? true : false;
    }

    public static boolean isLater(Date checkDate) {
        Calendar now = Calendar.getInstance();
        return now.getTimeInMillis() - checkDate.getTime() > 0 ? true : false;
    }
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 时间差值 开始 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

    /**
     * 计算相差 天数
     *
     * @param startDate
     * @param endDate
     * @param calType   计算方式 1.分钟, 2.小时, 3.天
     * @return Differ Day
     * @throws ParseException
     */
    public static long getDiffer(String startDate, String endDate, String formatType, Integer calType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date1 = formatter.parse(startDate);
        Date date2 = formatter.parse(endDate);
        long differ_s = date2.getTime() - date1.getTime();
        long differ = 0;
        if (calType == 1) {
            //分钟
            differ = differ_s / (60 * 1000);
        } else if (calType == 2) {
            //小时
            differ = differ_s / (60 * 60 * 1000);

        } else if (calType == 3) {
            //天
            differ = differ_s / (24 * 60 * 60 * 1000);
        }
        return differ;
    }

    public static long getDifferDay(Date begDate, Date endDate) {
        long differ_s = begDate.getTime() - endDate.getTime();
        long differ_d = differ_s / (24 * 60 * 60 * 1000);
        return differ_d;
    }

    public static double getDifferHour(Date begDate, Date endDate)
            throws ParseException {
        long differ_s = endDate.getTime() - begDate.getTime();
        long differ_h = differ_s / (60 * 60 * 1000);
        return differ_h;
    }


    /**
     * 两个时间点相差的   秒数
     *
     * @param minuend
     * @param subtrahend
     * @return 两个时间点相差的秒数(minuend - subtrahend)
     */
    public static long sub(Date minuend, Date subtrahend) {
        long sub = 0;
        if (minuend == null || subtrahend == null) {
            throw new IllegalArgumentException();
        }
        sub = minuend.getTime() - subtrahend.getTime();
        return sub / 1000;
    }

    /**
     * 计算相差 天数
     *
     * @param beginDate
     * @param endDate
     * @return 两个时间点相差的天数(beginDate - endDate)
     */
    public static long between(Date beginDate, Date endDate) {
        Calendar calBegin = Calendar.getInstance();
        Calendar calEnd = Calendar.getInstance();
        calBegin.setTime(beginDate);
        calEnd.setTime(endDate);
        calBegin.clear(14);
        calEnd.clear(14);
        long millisecs = calBegin.getTime().getTime()
                - calEnd.getTime().getTime();
        long remainder = millisecs % 0x5265c00L;
        return (millisecs - remainder) / 0x5265c00L;
    }
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 时间差值 结束  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■ 返回 日期 指定值 开始  ■■■■■■■■■■■■■■■■■■■■■■■■■■
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

    /**
     * 返回Date对象的 年份
     *
     * @param date 日期
     * @return 返回年份
     */
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * 返回Date对象的 月份
     *
     * @param date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 返回Date对象的 日份
     *
     * @param date 日期
     * @return 返回日期
     */
    public static int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回Date对象的小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回Date对象的 分钟
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 返回秒
     *
     * @param date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }

    /**
     * 返回毫秒
     *
     * @param date 日期
     * @return 返回毫秒
     */
    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■ 返回 日期 指定值 结束 ■■■■■■■■■■■■■■■■■■■■■■■■■■

    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 相加  开始 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

    /**
     * 某日期 加 N月
     *
     * @param date  日期
     * @param month 加的月数
     * @return 返回相加后的日期
     */

    public static Date addMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }

    /**
     * 某日期 加 N天
     *
     * @param date 日期
     * @param days 加的天数
     * @return 返回相加后的日期
     */
    public static Date addDay(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) days) * 24 * 3600 * 1000);
        return c.getTime();
    }

    /**
     * 某日期 加 N小时
     *
     * @param date  日期
     * @param hours 小时数
     * @return 返回相加后的日期
     */
    public static Date addHours(Date date, int hours) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) hours) * 3600 * 1000);
        return c.getTime();
    }

    /**
     * 某日期 加 N分钟
     *
     * @param date    日期
     * @param minutes 分钟
     * @return 返回相加后的日期
     */
    public static Date addMinutes(Date date, long minutes) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + minutes * 60 * 1000);
        return c.getTime();
    }
    // ■■■■■■■■■■■■■■■■■■■■■■■■■■■ 相加 结束 ■■■■■■■■■■■■■■■■■■■■■■■■■■

    //@@@@@@@@@@@@@@@@@@@@@@@ Common转移过来 @@@@@@@@@@@@@@@@@@@@@@@@@@@@

    /**
     * @return 获取年月形式的上传文件夹名称
     */
    public static String getMonDir() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Calendar c = Calendar.getInstance();
        String strMonDir = sdf.format(c.getTime());
        strMonDir = "/" + strMonDir;
        return strMonDir;
    }

    public static String getNowDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        return formatter.format(today);
    }

    public static String getNowMonth() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        Date today = new Date();
        return formatter.format(today);
    }
//	public static String getLastMonth(){
//		SimpleDateFormat formatter=new SimpleDateFormat("yyyyMM");
//		Date today=new Date();
//		today.setMonth(today.getMonth()-1);
//		return formatter.format(today);
//	}
//	//得到今年的1月
//	public static String getJanuary(){
//		SimpleDateFormat formatter=new SimpleDateFormat("yyyyMM");
//		Date today=new Date();
//		today.setMonth(0);
//		return formatter.format(today);
//	}
//	//得到半年前的那个月
//	public static String getMonthHalfYearAgo(){
//		SimpleDateFormat formatter=new SimpleDateFormat("yyyyMM");
//		Date today=new Date();
//		today.setMonth(today.getMonth()-5);
//		return formatter.format(today);
//	}
//	public static String getMonthOneYearAgo(){
//		SimpleDateFormat formatter=new SimpleDateFormat("yyyyMM");
//		Date today=new Date();
//		today.setMonth(today.getYear()-1);
//		return formatter.format(today);
//	}
//	public static String getNowYear(){
//		SimpleDateFormat formatter=new SimpleDateFormat("yyyy");
//		Date today=new Date();
//		return formatter.format(today);
//	}
//	public static String getYesterday(){
//		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
//		Date YesterDay = new Date();
//		YesterDay.setDate(YesterDay.getDate()-1);   
//        String yesterday = formatter.format(YesterDay);
//		return yesterday;
//	}

    //得到前30天
//	public static String getAhead30day(){
//		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
//		Date YesterDay = new Date();
//		YesterDay.setDate(YesterDay.getDate()-30);   
//        String ahead30day = formatter.format(YesterDay);
//		return ahead30day;
//	}

    /**
     * 得到X月的第一天
     * @param monthIncrement 增量
     * @return 日期字符串
     */
    public static String getFirstofForMonth(Integer monthIncrement) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) + monthIncrement);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return sdf.format(calendar.getTime());
    }

    //得到X月最后一天
//    public static String getEndofLastMonth(Integer monthIncrement) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) + monthIncrement);
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        calendar.set(Calendar.DAY_OF_MONTH, 0);
//        return sdf.format(calendar.getTime());
//    }

    /**
     * 增加X天
     * @param date 日期
     * @param amount 增量
     * @return 返回日期
     */
    public static Date addDays(Date date, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, amount);
        return c.getTime();
    }
}
