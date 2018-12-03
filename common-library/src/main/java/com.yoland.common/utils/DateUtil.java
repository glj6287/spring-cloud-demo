package com.yoland.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * <p>Title:跟时间有关的便利方法 DateUtil.java</p>
 *
 */
public class DateUtil {

    /**
     * 一秒中的等价毫秒数
     */
    public static final long SECOND = 1000;
    /**
     * 一分钟的等价毫秒数
     */
    public static final long MINUTE = 60 * SECOND;
    /**
     * 一小时的等价毫秒数
     */
    public static final long HOUR = 60 * MINUTE;
    /**
     * 一天的等价毫秒数
     */
    public static final long DAY = 24 * HOUR;
    /**
     * 半小时的等价毫秒数
     */
    public static final long HALF_HOUR = HOUR / 2;

    /**
     * 格式化日期（yyyyMMdd）
     */
    public static final String SHORT_DATEPATTERN = "yyyyMMdd";
    /**
     * 格式化日期（yyyy-MM-dd hh:mm:ss）
     */
    public static final String DEFAULT_DATEPATTERN = "yyyy-MM-dd hh:mm:ss";
    /**
     * 格式化日期（yyyy-MM-dd HH:mm:ss）
     */
    public static final String DEFAULT_DATESFM = "yyyy-MM-dd HH:mm:ss";
    /**
     * 格式化日期（yyyy-MM-dd HH:mm）
     */
    public static final String DEFAULT_MINUS = "yyyy-MM-dd HH:mm";
    /**
     * 格式化日期（yyyyMMddHHmmss）
     */
    public static String STR_PATTERN = "yyyyMMddHHmmss";
    /**
     * 格式化日期（yyyy-MM-dd）
     */
    public static final String SAMPLE_DATEPATTERN = "yyyy-MM-dd";
    /**
     * 格式化日期（yyyyMMdd）
     */
    public static final String SHORT_DATE_PATTERN = "yyyyMMdd";
    /**
     * 格式化日期(yyyy年MM月dd日)
     * */
    public static final String SHORT_CHAR_DATE_PATTERN="yyyy年MM月dd日";
    /**
     * 格式化日期（HHmmss）
     */
    public static final String StR_PATTERN_HHMMSS = "HHmmss";
    
    /**
     * 格式化时间（HH:mm:ss）
     */
    public static final String StR_PATTERN_HHMMSS1 = "HH:mm:ss";
    
    public static final String StR_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    /**
     * 格式：yyyyMMdd，8位
     */
    public static final String PATTERN_NUM_DATE = "yyyyMMdd";

    /**
     * 格式：yyyyMMddHHmmss，14位
     */
    public static final String PATTERN_NUM_SEC = "yyyyMMddHHmmss";

    /**
     * 格式：yyyyMMddHHmmssSSS，17位
     */
    public static final String PATTERN_NUM_MS = "yyyyMMddHHmmssSSS";

    /**
     * 格式：yyyy.MM.dd
     */
    public static final String PATTERN_DOT_YMD = "yyyy.MM.dd";


    
    public static String defaultFormat(Date date) {
    	return new SimpleDateFormat(DEFAULT_DATEPATTERN).format(date);
    }
    
    /**
     * 获取今天凌晨的0分0秒这个时间
     */
    public static Date getDayBegin() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取昨天凌晨的0分0秒这个时间
     */
    public static Date getYesterdayDayBegin() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定日期凌晨的0分0秒这个时间
     * @param date
     * @return
     */
    public static Date getBegin(Date date){
    	String dateStr = DateUtil.shortDateString(date, SHORT_DATE_PATTERN);
    	Date dayBegin = DateUtil.shortStringToDate(dateStr, SHORT_DATE_PATTERN);
    	return dayBegin;
    }
    
    /**
     * 判断今天是否是周末。是则返回true,否则返回false
     */
    public static boolean isWeekEnd() {
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        }
        return false;
    }

    /**
     * 判断今天是否是星期一，是则返回true,否则返回false
     */
    public static boolean isWeekStart() {
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            return true;
        }
        return false;
    }

    /**
     * 判断今天是否是一号，是则返回true,否则返回false
     */
    public static boolean isMonthStart() {
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    }

    /**
     * 判断今天是否是月末，是则返回true,否则返回false
     */
    public static boolean isMonthEnd() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        if (cal.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @return 返回明天凌晨0点0分0秒
     */
    public static Date getNextDay() {
        return getNextHour(0);
    }

    /**
     * @return 返回指定时间(x点整)最靠近的时间, 如果今天已经过了那个时间, 则返回明天的那个时间
     *         否则返回今天的那个整点时间
     */
    public static Date getNextHour(int hour) {
        return getNextTime(hour, 0);
    }

    /**
     * @param hour 几点
     * @param min  几分
     * @return 获得指定时间(x点y分)最靠近的时间, 如果今天已经过了那个时间, 则返回明天的那个时间
     *         否则返回今天的那个时间
     */
    public static Date getNextTime(int hour, int min) {
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.HOUR_OF_DAY) > hour) {
            calendar.add(Calendar.DATE, 1);
        } else if (calendar.get(Calendar.HOUR_OF_DAY) == hour &&
                calendar.get(Calendar.MINUTE) >= min) {
            calendar.add(Calendar.DATE, 1);
        }
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取指定的日期
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @param hour  小时
     * @param min   分
     * @return
     */
    public static Date getTime(int year, int month, int day, int hour, int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取月初的时间
     *		年月 1号 0 时 0 分 0 秒
     * @return
     */
    public static Date getMonthBenin() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前月份+month月初时间，时间为  00:00:00
     * @return
     */
    public static Date getNextMonthBeginTime(int month){
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.MONTH, month);  
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        calendar.set(Calendar.HOUR,12);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
    	return calendar.getTime();
    }
    
    /**
     * 获取相继几天的时间
     *
     * @param before
     * @return
     */
    public static Date getDayBefore(int before) {
        return getDayBefore(null, before);
    }

    /**
     * 获取日期之后几天的的日期
     * 
     * @param date	为空时当前时间
     * @param before
     * @return
     */
    public static Date getDayBefore(Date date, int before) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - before);
        return calendar.getTime();
    }

    /**
     * 获取date之前或之后number天的日期
     *
     * @param date
     * @param number 正数 当前日期之后   负数：当前日期之前
     * @return
     */
    public static Date getAfterOrBeforeDay(Date date, int number) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.add(Calendar.DAY_OF_MONTH, number);
        return calendar.getTime();
    }

    /**
     * 获取当前日期之前或之后number天的日期
     *
     * @param number 正数 当前日期之后   负数：当前日期之前
     * @return
     */
    public static Date getAfterOrBeforeDay(int number) {
        return getAfterOrBeforeDay(new Date(), number);
    }

    /**
     * @param date
     * @return
     */
    public static String shortDateString(Date date) {
        if (date == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat(SAMPLE_DATEPATTERN);
        return sdf.format(date);
    }

    /**
     * 按照格式返回日期字符串
     *
     * @param date
     * @param format (如：yyyyMMdd )
     * @return
     */
    public static String shortDateString(Date date, String format) {
        if (date == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 根据时间字串和格式化标准进行格式化
     *
     * @param dateStr {String} 时间字串
     * @param format  {String} 格式化标准 【exam:'yyyy-MM-dd hh:mm:ss'】
     * @return {java.util.Date}
     */
    public static Date shortStringToDate(String dateStr, String format) {
        Date date = null;

        if (null == dateStr) {
            date = new Date();
        } else {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                date = sdf.parse(dateStr);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return date;
    }

    public static Date shortStringToDate(String dateStr) {
        return shortStringToDate(dateStr, SAMPLE_DATEPATTERN);
    }
    public static Date shortStringToDateFormat(String dateStr,String format) {
        return shortStringToDate(dateStr, format);
    }
    /**
     * 将不同类型的日期格式转成指定格式字符串
     *
     * @param date
     * @param format (如：yyyyMMdd )
     * @return
     */
    public static String shortDateString(String date, String format) {
        if (date == null)
            return "";
//    	SimpleDateFormat sdf = new SimpleDateFormat(format);
        return shortDateString(shortStringToDate(date, format), format);
    }

    /**
     * 计算2个日期的间隔的秒数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long elapsedSecond(Date d1, Date d2) {
        long d = Math.abs(d1.getTime() - d2.getTime());
        return d / 1000;
    }

    /**
     * 计算2个日期间隔的分钟数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long elapsedMinute(Date d1, Date d2) {
        return elapsedSecond(d1, d2) / 60;
    }

    /**
     * 计算2个日期间隔的小时数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long elapsedhour(Date d1, Date d2) {
        return elapsedMinute(d1, d2) / 60;
    }

    public static long elapsedMonth(Date d1, Date d2) {
        return elapsedDay(d1, d2) / 30;
    }

    /**
     * 计算2个日期间隔的天数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static int elapsedDay(Date d1, Date d2) {
        return (int) elapsedhour(d1, d2) / 24;
    }

    /**
     * 计算2个日期间隔的年数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Double elapsedYear(Date d1, Date d2) {
        return new Double(elapsedDay(d1, d2) / 365.0);
    }

    /**
     * 获取当前月-number的日期
     *
     * @param number
     * @return
     */
    public static Date getDateBeforeOfMonth(int number) {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) - number);
        return now.getTime();
    }

    public static String simpleFormat(Date date){
        return new SimpleDateFormat(SHORT_DATE_PATTERN).format(date);
    }

    /**
     * 获取当前月-number的日期
     *
     * @param number
     * @return
     */
    public static Date getDateBeforeOfMonth(Date date, int number) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) - number);
        return now.getTime();
    }

    /**
     * 获取当前月+number的日期
     *
     * @param month
     * @return
     */
    public static Date getDateAfterOfMonth(int month) {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) + month);
        return now.getTime();
    }

    /**
     * 获取月+number的日期
     *
     * @param month
     * @return
     */
    public static Date getDateAfterOfMonth(Date date, int month) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.MONTH, now.get(Calendar.MONTH) + month);
        return now.getTime();
    }
    /**
     * 获取当前年+number的日期
     *
     * @param year
     * @return
     */
    public static Date getDateAfterOfYear(int year) {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        now.set(Calendar.YEAR, now.get(Calendar.YEAR) + year);
        return now.getTime();
    }
    /**
     * 获取年+number的日期
     *
     * @param year
     * @return
     */
    public static Date getDateAfterOfYear(Date date, int year) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.YEAR, now.get(Calendar.YEAR) + year);
        return now.getTime();
    }

    /**
     * 获得2个日期之间的时间间隔
     *
     * @param da1(起始日期 格式：yyyy yyyyMM yyyyMMdd)
     * @param da2(截止日期)
     * @return
     */
    public static String getTimeBetweenDates(String da1, String da2) {
        String str = "";
        if (StringUtils.isEmpty(da1) || StringUtils.isEmpty(da2) || !StringUtils.isNumeric(da1) || !StringUtils.isNumeric(da2)||"19000101".equals(da1)) {
            return "--";
        }
        Date now = new Date();
        int years = 0;
        int months = 0;
        if (da1.length() == 4 || da2.length() == 4) {
            String dateStr1 = da1.substring(0, 4);
            String dateStr2 = da2.substring(0, 4);
            years = Integer.valueOf(dateStr2) - Integer.valueOf(dateStr1);
            str = years + "年";
        } else if (da1.length() == 6 || da2.length() == 6) {
            String yearStr1 = da1.substring(0, 4);
            String yearStr2 = da2.substring(0, 4);
            years = Integer.valueOf(yearStr2) - Integer.valueOf(yearStr1);
            String monthStr1 = da1.substring(4, 6);
            String monthStr2 = da2.substring(4, 6);
            months = Integer.valueOf(monthStr2) - Integer.valueOf(monthStr1);
            if (months < 0) {
                years = years - 1;
                months = months + 12;
            }
            if (years > 0) {
                str = years + "年";
            }
            if (months > 0) {
                str = str + months + "月";
            }
        } else {
            str = getTimeBetweenDates(shortStringToDate(da1, "yyyyMMdd"), shortStringToDate(da2, "yyyyMMdd"));
        }
        return str;
    }

    /**
     * 获得2个日期之间的时间间隔（如：1年124天）
     *
     * @param da1
     * @param da2
     * @return
     */
    public static String getTimeBetweenDates(Date da1, Date da2) {
        String str = "";
        if (da1 == null || da2 == null || "19000101".equals(da1)) {
            return "--";
        }
        if (da1.getTime() > da2.getTime()) {
            return getTimeBetweenDates(da2, da1);
        } else {
            int year1 = da1.getYear();
            int year2 = da2.getYear();
            if (year1 == year2) {
                int days = elapsedDay(da1, da2);
                str = days + "天";
            } else {
                int years = year2 - year1 - 1;
                Date date1 = new Date();
                date1.setYear(da1.getYear());
                date1.setMonth(11);
                date1.setDate(31);
                int days1 = elapsedDay(da1, date1);
                Date date2 = new Date();
                date2.setYear(da2.getYear());
                date2.setMonth(0);
                date2.setDate(1);
                int days2 = elapsedDay(date2, da2) + 1;
                int days = days1 + days2;
                if (days >= 365) {
                    days = days - 365;
                    years++;
                }
                if (years > 0) {
                    str = years + "年";
                }
                if (days > 0) {
                    str = str + days + "天";
                }

            }

        }
        return str;
    }

    /**
     * 获取前几个季度的日期
     *
     * @return
     */
    public static List<String> getQuarter(int length, int number) {
        List<String> list = new ArrayList<String>();
        String[] dateStr = {"0331", "0630", "0930", "1231"};
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int quarter = cal.get(Calendar.MONTH) / 3 + 1;
        quarter = quarter - number;
        //jack change 2012.1.4
        while (quarter <= 0) {
            quarter = quarter + 4;
            year = year - 1;
        }

        for (int i = 0; i < length; i++) {
            if (quarter == 1) {
                quarter = 4;
                year -= 1;
            } else {
                quarter -= 1;
            }
            list.add(year + dateStr[quarter - 1]);
        }
        return list;
    }
    
	/**
	 * 取上季度末日期
	 *
	 * @param quarterDay
	 * @return
	 */
	public static String getLastQuarterDay(String quarterDay) {
		if ("0331".equals(quarterDay.substring(4))) {
			int year = Integer.valueOf(quarterDay.substring(0, 4)).intValue();
			return String.valueOf(year - 1) + "1231";
		} else if ("0630".equals(quarterDay.substring(4))) {
			return quarterDay.substring(0, 4) + "0331";
		} else if ("0930".equals(quarterDay.substring(4))) {
			return quarterDay.substring(0, 4) + "0630";
		} else if ("1231".equals(quarterDay.substring(4))) {
			return quarterDay.substring(0, 4) + "0930";
		}
		return null;
	}


    /**
     * 计算年龄
     *
     * @param birthday 生日日期
     * @return {int}
     */
    public static int getAge(Date birthday) {
        int age = 0;

        try {
            Calendar cal = Calendar.getInstance();

            if (!cal.before(birthday)) {
//                throw new IllegalArgumentException(
//                    "出生时间大于当前时间!");
                int yearNow = cal.get(Calendar.YEAR);
                int monthNow = cal.get(Calendar.MONTH) + 1;
                int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
                cal.setTime(birthday);

                int yearBirth = cal.get(Calendar.YEAR);
                int monthBirth = cal.get(Calendar.MONTH) + 1;
                int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

                age = yearNow - yearBirth;

                if (monthNow <= monthBirth) {
                    if (monthNow == monthBirth) {
                        if (dayOfMonthNow < dayOfMonthBirth) {
                            age--;
                        }
                    } else {
                        age--;
                    }
                }
            }
        } catch (Exception e) {

        }

        return age;
    }

    /**
     * @param datePattern
     * @return
     */
    public static String formatNowDate(String datePattern) {
        if (datePattern == null) {
            datePattern = "yyyy-MM-dd";
        }
        SimpleDateFormat df = new SimpleDateFormat(datePattern);
        return df.format(new Date());
    }

    public static String thisYearStart() {
        Calendar cal = Calendar.getInstance();
        String date = cal.get(Calendar.YEAR) + "0101";
        return date;
    }


    /**
     * 得到日期的前或者后几小时
     *
     * @param iHour 如果要获得前几小时日期，该参数为负数；
     *              如果要获得后几小时日期，该参数为正数
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后几小时
     * @see Calendar#add(int, int)
     */
    public static Date getDateBeforeOrAfterHours(Date curDate, int iHour) {
        Calendar cal = Calendar.getInstance();
        if (curDate != null) {
            cal.setTime(curDate);
        }
        cal.add(Calendar.HOUR_OF_DAY, iHour);
        return cal.getTime();
    }

    //获得周五的日期
    public static Date getFriday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        return c.getTime();
    }

    /**
     * 时间转换
     * @param d
     * @param fmt
     * @return
     */
    public static Date parseDate(String d, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        try {
            return sdf.parse(d);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);
        return calendar.getTime();
    }

    /**
     * 获取相继几天的时间
     *
     * @param before
     * @return
     */
    public static Date getDayBofore(int before) {
        return getDayBofore(null, before);
    }

    /**
     * @param date
     * @param before
     * @return
     */
    public static Date getDayBofore(Date date, int before) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);

        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - before);
        return calendar.getTime();
    }

    /**
     * 得到日期的前或者后几分钟
     *
     * @param curDate 如果要获得前几分钟时间，该参数为负数；
     *              如果要获得后几分钟时间，该参数为正数
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后几分钟
     * @see Calendar#add(int, int)
     */
    public static Date getDateBeforeOrAfterMinute(Date curDate, int min) {
        Calendar cal = Calendar.getInstance();
        if (curDate != null) {
            cal.setTime(curDate);
        }
        cal.add(Calendar.MINUTE, min);
        return cal.getTime();
    }

    /**
     * 得到日期的前或者后几秒钟
     *
     * @param curDate 如果要获得前几秒钟时间，该参数为负数；
     *              如果要获得后几秒钟时间，该参数为正数
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后几秒钟
     * @see Calendar#add(int, int)
     */
    public static Date getDateBeforeOrAfterSecond(Date curDate, int second) {
        Calendar cal = Calendar.getInstance();
        if (curDate != null) {
            cal.setTime(curDate);
        }
        cal.add(Calendar.SECOND, second);
        return cal.getTime();
    }

    /**
     * 得到当前的的年
     *
     * @return 当前的年
     */
    public static int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
    
    /**
     * 根据日期得到当前季度数
     * @param date  format yyyyMMdd
     * @return 1:一季度；2：二季度；3：三季度；4：四季度 ；0：无
     */
    public static int getSeasonNum(String date){
    	String month=date.substring(4, 6);
    	if("01".equals(month) ||"02".equals(month) ||"03".equals(month)){
    		return 1;
    	}else if("04".equals(month) ||"05".equals(month) ||"06".equals(month)){
    		return 2;
    	}else if("07".equals(month) ||"08".equals(month) ||"09".equals(month)){
    		return 3;
    	}else if("10".equals(month) ||"11".equals(month) ||"12".equals(month)){
    		return 4;
    	}
    	return 0;
    }
    
    /**
     * 取得某个年份某个季度的季末日期
     * @param year 年份
     * @param season 季度数
     * @return 季末日期，如果无，返回null
     */
	public static String getSeasonEndDate(int year, int season) {				
		if (season == 1) {
			return year+"0331";
		} else if (season == 2) {
			return year+"0630";
		} else if (season == 3) {
			return year+"0930";
		} else if (season == 4) {
			return year+"1231";
		}

		return null;
	}
	
	/**
	 * 根据日期取得当前季度季末日期
	 * @param date format: yyyyMMdd
	 * @return String 若无，返回null
	 */
	public static String  getCurSeasonEndDate(String date){
		String year =date.substring(0, 4);
		String month=date.substring(4, 6);
		if("01".equals(month) ||"02".equals(month) ||"03".equals(month)){
			return year+"0331";
    	}else if("04".equals(month) ||"05".equals(month) ||"06".equals(month)){
    		return year+"0630";
    	}else if("07".equals(month) ||"08".equals(month) ||"09".equals(month)){
    		return year+"0930";
    	}else if("10".equals(month) ||"11".equals(month) ||"12".equals(month)){
    		return year+"1231";
    	}
		return null;
	}
	
    /**
     * 获取当前时间，精确到秒
     * 时间格式为yyyyMMddHHmmss
     *
     * @return String
     * 精确到秒的当前时间
     */
    public static String getCurrentDateTime() {
        return getDateTimeByPattern(PATTERN_NUM_SEC);
    }

    /**
     * 获取当前时间，精确到毫秒
     * 时间格式为yyyyMMddHHmmssSSS
     *
     * @return String
     * 精确到毫秒的当前时间
     */
    public static String getCurrentDateTimeMs() {
        return getDateTimeByPattern(PATTERN_NUM_MS);
    }
    /**
     * 依据传入的时间格式获取当前时间
     * 比如传入的是yyyyMMdd,则获取的是精确到天的当前时间
     * 比如传入的是yyyyMMddHHmmss,则获取的是精确到秒的当前时间
     *
     * @param pattern 时间格式字符串
     * @return String
     * 符合要求的时间
     */
    public static String getDateTimeByPattern(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间的前一天
     */
    public static Date getBeforeDate(Date date) {
        Date dNow = new Date();   //当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
        dBefore = calendar.getTime();   //得到前一天的时间
        return dBefore;
    }
    /**
     * 日期转换成字符串（格式：yyyyMMdd）
     * 
     * @param date
     * @return
     */
    public static String getDate(Date date){
        return new SimpleDateFormat(SHORT_DATE_PATTERN).format(date);
    }

    /**
     * 把yyyymmdd的字符串转化为yyyy-mm-dd格式的日期
     * @param str
     * @return
     */
    public static Date strToDate(String str){
    	if(null == str || "".equals(str) || str.length() < 1){
    		return new Date();
    	}
    	StringBuffer sb = new StringBuffer();
    	String y = str.substring(0,4);
    	String m = str.substring(4,6);
    	String d = str.substring(6,8);
    	sb.append(y).append("-").append(m).append("-").append(d);
    	return shortStringToDate(sb.toString());
    }
    
    /**
     * TODO 获取当月的第一天或最后一天 
     * @author lsy
     * 2017年2月28日 上午10:49:31
     * @param a=0,b=1  当月第一天
     * @param a=1,b=0  当月最后一天
     * @return
     */
    public static String monthFirstOrLast(int a,int b){
    	Calendar cale = Calendar.getInstance();
    	cale.add(Calendar.MONTH, a);  
        cale.set(Calendar.DAY_OF_MONTH, b);
        return shortDateString(cale.getTime());
    }
    /**
	 * yyyyMMddHHmmss
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr3(Date date) {
		return dateStr(date, PATTERN_NUM_SEC);
	}
	
	/**
	 * 日期转换为字符串 格式自定义
	 * 
	 * @param date
	 * @param f
	 * @return
	 */
	public static String dateStr(Date date, String f) {
		SimpleDateFormat format = new SimpleDateFormat(f);
		String str = format.format(date);
		return str;
	}
	
	/**
	 * yyyyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr7(Date date) {
		return dateStr(date, SHORT_DATEPATTERN);
	}
	/**
	 * 获得当前日期
	 * @return
	 */
	public static Date getNow() {
		Calendar cal = Calendar.getInstance();
		Date currDate = cal.getTime();
		return currDate;
	}
	
	/**
	 * 根据原有时间+月数得到新的时间
	 * @param olddate
	 * @param recordDate
	 * @return
	 * @throws ParseException
	 */
	public static Date getnewDate(Date olddate, String recordDate) throws ParseException {
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(olddate);
//		int startDay = calendar.get(Calendar.DATE);
		calendar.add(Calendar.MONTH, Integer.valueOf(recordDate));
//		int maxEndMonthDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		  return calendar.getTime();
		}
	
	/**
	 * 原时间-天数=新的时间
	 * @param date
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static Date reduceDate(Date date,long day) throws ParseException {
		 long time = date.getTime(); // 得到指定日期的毫秒数
		 day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
		 time=time-day; // 相加得到新的毫秒数
		 return new Date(time); // 将毫秒数转换成日期
	}
	
	/**
	 * 原有时间+天数 = 新的时间
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDate(Date date,long day) {
        long time = date.getTime(); // 得到指定日期的毫秒数
        day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
        time+=day; // 相加得到新的毫秒数
        return new Date(time); // 将毫秒数转换成日期
    }
	
	
    /** 
     *  获取两个日期相差的月数 
     * @param endtime    较大的日期 
     * @param starttime    较小的日期 
     * @return  如果d1>d2返回 月数差 否则返回0 
     * 如果时间不满一个月就进1
     */  
//    public static int getMonthDiff(Date endtime, Date starttime , int fumonth)throws ParseException  {  
//    	//代码中的endtime是实质上到 0:0:0  业务中实质是 23:59:59 所以结束时间+1
//    	Integer day= 1 ;
//		endtime = addDate(endtime,day);
//		
//        Calendar c1 = Calendar.getInstance();  
//        Calendar c2 = Calendar.getInstance();  
//        c1.setTime(endtime);  
//        c2.setTime(starttime);  
//        if(c1.getTimeInMillis() < c2.getTimeInMillis()) return 0;  
//        int year1 = c1.get(Calendar.YEAR);  
//        int year2 = c2.get(Calendar.YEAR);  
//        int month1 = c1.get(Calendar.MONTH);  
//        int month2 = c2.get(Calendar.MONTH);  
//        int day1 = c1.get(Calendar.DAY_OF_MONTH);  
//        int day2 = c2.get(Calendar.DAY_OF_MONTH);
//        // 获取年的差值 假设 d1 = 2015-8-16  d2 = 2011-9-30  
//        int yearInterval = year1 - year2;  
//        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数  
//        if(month1 < month2 || month1 == month2 && day1 < day2) yearInterval --;  
//        // 获取月数差值  
//        int monthInterval =  (month1 + 12) - month2  ;  
//        if(day1 < day2) monthInterval --;  
//        if(day1 > day2) monthInterval ++;  
//        monthInterval %= 12; 
//        System.out.println("monthInterval---"+monthInterval);
//        int month = yearInterval * 12 + monthInterval ;
//        System.out.println("month---"+month);
//        int cishu = month/fumonth;
//        int yushu = month%fumonth;
//        System.out.println("cishu---"+month);
//        System.out.println("yushu---"+month);
//        if(yushu>0){
//        	cishu+= 1 ;
//        }
//        System.out.println("last cishu---"+month);
//        return cishu;  
//    }  
    
	 /** 
     *  获取两个日期相差的月数 
     * @param d1    较大的日期
     * @param d2    较小的日期
     * @return  如果d1>d2返回 月数差 否则返回0 
     * 如果时间不满一个月就进1
     */
    public static int getMonthDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1); //结束时间
        c2.setTime(d2); //开始时间
        if(c1.getTimeInMillis() < c2.getTimeInMillis()) return 0;
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 假设 d1 = 2015-8-16 d2 = 2011-9-30
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if(month1 < month2 || month1 == month2 && day1 < day2) yearInterval --;
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2 ;
        if(day1 < day2) monthInterval --;
        monthInterval %= 12;
        
        int months = yearInterval * 12 + monthInterval;
        
        Calendar c3 = Calendar.getInstance();
        
        	c3.set(c2.get(Calendar.YEAR), c2.get(Calendar.MONTH)+months,c2.get(Calendar.DAY_OF_MONTH));
        	 Date endD = c3.getTime();
        	 Date endT = c2.getTime();
//        	int days= elapsedDay( endD,  endT);
        	if(compareDate(endT,endD)<0) {
        		months =months+1;
        	}
        return months;
    }
    
    
//    /** 
//     *  获取两个日期相差的年数 
//     * @param endtime    较大的日期 
//     * @param starttime    较小的日期 
//     * @return  如果d1>d2返回 月数差 否则返回0 
//     * 如果时间不满一年就进1
//     */
//    public static int getYearDiff(Date d1, Date d2) {
//    	
//    	Double yearInterval = new Double(elapsedDay(d1, d2) / 365.0)
//		 
//		 
//        return yearInterval.intValue();
//    }
    
    /** 
     *  获取两个日期相差的月数 
     * @param d1    较大的日期
     * @param d2    较小的日期
     * @return  如果d1>d2返回 月数差 否则返回0 
     * 如果时间不满一个月 舍去
     */
    public static int getRealMonthDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1); //结束时间
        c2.setTime(d2); //开始时间
        if(c1.getTimeInMillis() < c2.getTimeInMillis()) return 0;
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 假设 d1 = 2015-8-16 d2 = 2011-9-30
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if(month1 < month2 || month1 == month2 && day1 < day2) yearInterval --;
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2 ;
        if(day1 < day2) monthInterval --;
        monthInterval %= 12;
        
        int months = yearInterval * 12 + monthInterval;
      
        return months;
    }
    
    
    /**
     * 获取两个时间的相差天数
     * @param endDate
     * @param startDate
     * @return
     */
    public static int getDaysDiff(Date endDate,Date startDate)throws ParseException 
    {
    	//代码中的endtime是实质上到 0:0:0  业务中实质是 23:59:59 所以结束时间+1
    	Integer day= 1 ;
    	endDate = addDate(endDate,day);
		
        int days = (int) ((endDate.getTime() - startDate.getTime()) / (1000*3600*24));
        return days;
    }
    

    
	/**
	 * 获取账期的结束日期，传入起租日期，以及账期结束是第几个月
	 * @param
	 * @param months
	 * @return
	 * @throws ParseException
	 */
    public static Date getBillEndDate(Date billStartTime, Integer months) throws ParseException {
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(billStartTime);
		int startDay = calendar.get(Calendar.DATE);
		calendar.add(Calendar.MONTH, months);
		int maxEndMonthDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		if(startDay > maxEndMonthDay) {
			return calendar.getTime();
		}else {
			calendar.add(Calendar.DATE, -1);
			return calendar.getTime();
		}
	}
    
    /**
     * 将字符串转成date，date转成（yyyy-MM-dd）等
     * @param date
     * @param format
     * @return
     */
    public static String dateToStr(String date, String format) {
    	SimpleDateFormat formatter = new SimpleDateFormat(format);
    	Date dates =parseDate(date,"yyyy-MM-dd");
    	String dateString = formatter.format(dates);
    	return dateString;
    }
    
   /* *//**
     * 账期时间计算 账期开始结束时间，相差月数，相差天数
     * @param startTime
     * @param endTime
     * @param months
     * @param countPeriod
     * @return
     * @throws Exception
     *//*
    public static List<Map> getbillTime(Date startTime , Date endTime , Integer months ,Integer countPeriod) throws Exception  {
    	List<Map> billTimeList = new ArrayList<>();
    	//开始时间固定+1
    	Integer day = 1 ;
    	Integer month = 1 ;
    	for (int i = 0; i < countPeriod; i++) {
    		Map<String, Object> map= new HashMap<String, Object>();
    		Date billStartTime = addDate(startTime,day);
    		Date billEndTime = null ;
    		if(i==countPeriod-1){
    			billEndTime=endTime;
    		}else{
            	billEndTime = getBillEndDate(billStartTime , months);
    		}
        	startTime=billEndTime ;
        	//计算相差几个月 用于应付金额 ，【注：不满1进1】
        	Integer monthNumber = getMonthDiff(billEndTime,billStartTime,month);
        	Integer days = getDaysDiff(billEndTime,billStartTime);
        	map.put("billStartTime",billStartTime );
        	map.put("billEndTime",billEndTime );
        	map.put("monthNumber",monthNumber);
        	map.put("days",days);
        	map.put("currentPeriod",i+1);
        	billTimeList.add(map);
		}
    	return billTimeList ;
    }*/
    
    
 /*   public static void main(String[] args) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date start = format.parse("2017-03-04");
			Date end = format.parse("2020-06-04");
			Integer months = 12 ;
			int countPeriod = getMonthDiff(end,start,months);
			List<Map> timeInfoList=getbillTime(start,end,months,countPeriod);
			for (Map map : timeInfoList) {
				String  billStartTime = format.format(map.get("billStartTime")) ;
				String billEndTime = format.format(map.get("billEndTime"));
				String monthNumber =map.get("monthNumber").toString();
				String days = map.get("days").toString();
				System.out.println("billStartTime:"+billStartTime+"/billEndTime:"+billEndTime+"/monthNumber:"+monthNumber+"/days:"+days);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

    /**
     * 计算时间差
     * @param dateStart
     * @param dateEnd
     * @return xxx天xxx小时
     */
    public static String calTimeDiff(Date dateStart, Date dateEnd){
        DateTime dtStart = new DateTime(dateStart);
        DateTime dtEnd = new DateTime(dateEnd);
        String day = Days.daysBetween(dtStart, dtEnd).getDays() + "天 ";
        String hours = Hours.hoursBetween(dtStart, dtEnd).getHours() % 24 + "小时";
        return day + hours;
    }

    /**
     *  时间格式 2016-08-15T16:00:00.000Z 转换
     * @param date
     * @return
     */
    public static Date changeDate(String date){
        try {
            if (StringUtils.isBlank(date)){
                return null;
            }
            date = date.replace("Z"," UTC");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算时间差，与当前时间比较
     * @param dateStart
     * @return xxx天xxx小时
     */
    public static String calTimeDiff(Date dateStart){
        return calTimeDiff(dateStart, new Date());
    }

	
    
    /** 
     *  两个时间的大小
     * @return  
     */  
    public static int compareDate(Date dt1,Date dt2){
        if (dt1.getTime() > dt2.getTime()) {//dt1 在dt2前
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {//dt1在dt2后
            return -1;
        } else {//相等
            return 0;
        }
    }
    
    
    /** 
     *  判断今年是否是闰年 
     * @return  
     */  
    public static boolean isLeapYear(Date date){
    	
    	Calendar dateCalendar = Calendar.getInstance();
    	dateCalendar.setTime(date);
    	
    	boolean isLeapYear = false;
    	int year = dateCalendar.YEAR;
		
    	 if(year%4==0&&year%100!=0||year%400==0){
    		 isLeapYear = true;
         }
    	 
    	 return isLeapYear;
    }

    /**
     *
     * 月份计算说明:其中起租日期起租日大于退租日期中当月的最大日,并且退租日期当月最后一天，则算整月
     * 如:起租日期为2017.01.30，退租日期2017.02.28 那么就算一个月
     * 退租日大于起租日-1时，不足一月的天数为:退租日-起租日+1
     * 退租日小于起租日-1时，不足一月的天数为:上月天数-(起租日-1)(起租日-1>上月天数时则为0)+退租日
     * @param start
     * @param end
     * @return
     */
	public static double twoDateIntervalMonths(String start,String end) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        
		try {
			
			Date startDate = dateFormat.parse(start);
        
	        startCalendar.setTime(startDate);
	        
	        Date endDate = dateFormat.parse(end);
	
	        endCalendar.setTime(endDate);
        
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int startYear = startCalendar.get(Calendar.YEAR);
		int endYear = endCalendar.get(Calendar.YEAR);
		int startMonth = startCalendar.get(Calendar.MONTH);
		int endMonth = endCalendar.get(Calendar.MONTH);
		int startDay = startCalendar.get(Calendar.DATE);
		int endDay = endCalendar.get(Calendar.DATE);
		double months  = 0d;
		
		if(endDay + 1 >= startDay && 
				!(startDay == 1 && endDay == endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH))) {
			months = (endYear - startYear) * 12 + endMonth - startMonth + ((double)endDay - (double)startDay + 1) / 365 * 12;
		}else if(endDay + 1 >= startDay 
				&& startDay == 1 && endDay == endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			months = (endYear - startYear) * 12 + endMonth - startMonth + 1;
		} else if(endDay + 1 < startDay && 
				!(startDay - 1 > endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH) 
						&& endDay == endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH))){
			endCalendar.add(Calendar.MONTH, -1);
			int startMonthLastDay = endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			int lastMonthDay =  startMonthLastDay - startDay + 1 < 0 ? 0 : startMonthLastDay - startDay + 1;
			months = (endYear - startYear) * 12 + endMonth - startMonth - 1 + ((double)lastMonthDay + (double)endDay) / 365 * 12;
		}else if(endDay + 1 < startDay 
				&& startDay - 1 > endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH) 
				&& endDay == endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			months = (endYear - startYear) * 12 + endMonth - startMonth;
		}
		return months;
	}

    /**
     * 中划线日期转为以点分隔为字符串日期
     * @param dateStr
     * @return
     */
	public static String format2Dot(String dateStr){
        return DateUtil.shortDateString(DateUtil.shortStringToDate(dateStr), PATTERN_DOT_YMD);
    }

    /**
     * 计算月 （租房账单计算月份）
     *
     * @param start
     *            起租日期
     * @param end
     *            结束租日期
     * @param pay
     *            付几
     * @return如果时间不满一个月就进1
     */
    public static int getBwtMonthPeriods(String start, String end, int pay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        int countPeriod = 1;
        int payInt = pay;
        boolean flag = true;
        try {
            Date startDate = dateFormat.parse(start);
            Date endDate = dateFormat.parse(end);

            while (flag) {

                Calendar cal = Calendar.getInstance();
                cal.setTime(startDate);

                int startDay = cal.get(Calendar.DATE);

                cal.add(Calendar.MONTH, payInt);
//				cal.add(Calendar.DATE, -1);

                int maxEndMonthDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                if (startDay > maxEndMonthDay) {
                } else {
                    cal.add(Calendar.DATE, -1);
                }

//				System.out.println("time : " +start +"----"+ dateFormat.format(cal.getTime()));
                int val = DateUtil.compareDate(cal.getTime(), endDate);
                if(val ==1 ) {//大于结束时间
                    flag  = false;
                }else if(val ==0){//等于结束时间
//					countPeriod++;
                    flag  = false;
                }else if(val == -1) {//小于结束时间
                    flag  = true;
                    countPeriod++;
                }


                payInt+=pay;
            }

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return countPeriod;

    }

    /**
     *  租金策略专用计算 时间 间隔月份
     * @param start
     * @param end
     * @return
     */
    public static int getBwtMonths(String start, String end) {
        int pay = 1;
        return getBwtMonthPeriods(start,end,pay);
    }

    public static void main(String[] args) {
        try {
//            System.out.println(shortDateString("20180620","yyyyMMdd"));
//            System.out.println(shortDateString("2018-11-29","yyyyMMdd"));
//            System.out.println(getBwtMonths("20180620","20181129"));
//            String startDate = "2018-11-29";
//            startDate = startDate.replaceAll("-","");
//            System.out.println(startDate);
//
//            String date = "2018-08-05T16:00:00.000Z";
//            date = date.replace("Z"," UTC");
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
//            System.out.println(format.parse(date));
//            shortStringToDate("2018-09-30");
//            compareDate(shortStringToDate("2018-09-30"),shortStringToDate("2018-09-31"));
//            System.out.println(shortStringToDate("2018-09-30"));
//            System.out.println(compareDate(shortStringToDate("2018-05-31"),shortStringToDate("2018-09-30")));

              List<String> list = DateUtil.getMonthBetween("2018-02-01","2018-09-06");
              for(int i=0;i<list.size();i++){
                  System.out.println(list.get(i));
                  String[] kpDateMs = list.get(i).split("\\|");
                  System.out.println(kpDateMs);
              }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param minDate 最小时间  2015-01-01
     * @param maxDate 最大时间 2015-10-01
     * @return 日期集合 格式为 年-月-日|年-月-日
     * @throws Exception
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) throws Exception {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式化为年月日

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        max.setTime(sdf.parse(maxDate));

        Calendar curr = min;
        while (curr.before(max)) {
            String start = sdf.format(curr.getTime());
            curr.add(Calendar.MONTH, 1);
            curr.add(Calendar.DATE, -1);
            String end = sdf.format(curr.getTime());
            if (curr.getTime().after(max.getTime())) {
                end = sdf.format(max.getTime());
            }
            result.add(start + "|" + end);
            curr.add(Calendar.DATE, 1);
        }
        return result;
    }

}
