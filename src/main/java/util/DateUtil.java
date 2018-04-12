package util;

import org.apache.commons.lang3.StringUtils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 日期转换工具类
 *
 * author Fan Peng
 */
public class DateUtil {

	public static final String DATE = "yyyy-MM-dd";
    public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
	public static final String YEAR = "yyyy";

	public static final String US_DATE = "MMM dd, yyyy";
	public static final String US_DATETIME = "MMM dd, yyyy HH:mm:ss";

	public static final String DATETIMECOMPACT = "yyyyMMddHHmmss";


	/*一周星期枚举*/
	public static enum DAY_IN_WEEK_ENUM {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};

	/**
	 * 尽可能将参数转换成日期
	 */
	public static  Date parse(Object obj) {
		if (obj == null) {
			return null;
		}
		if (obj instanceof String) {
			return parse((String) obj);
		}
		if (obj instanceof Date) {
			return (Date) obj;
		}
		if (obj instanceof Number) {
			Number n = (Number) obj;
			return new Date(n.longValue());
		}
		return null;
	}



	/**
	 * 按照DATETIME格式生成时间字符串
	 */
	public static String format(Object date) {
		return format(date, DATETIME);
	}

	/**
	 * 按照指定格式生成时间字符串
	 */
	public static String format(Object date, String pattern) {
		return format(date, pattern, Locale.getDefault());
	}

	/**
	 * 按照指定格式生成时间字符串
	 */
	public static String format( Object date, String pattern, Locale local) {
		Date d = parse(date);
		if (d == null)
			return "";
		return new SimpleDateFormat(pattern, local).format(d);
	}

	/**
	 * 取相对于当前时间‘前’或‘后’‘N’天的日期字符串
	 * param offset 正数为n天后，负数为n天前
	 * param pattern 输出格式，默认为DATETIME（即 yyyy-MM-dd HH:mm:ss）
	 */
	public static String getPrevOrNextNDay(int offset,  String pattern) {
		if (pattern == null)
			pattern = DATETIME;
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_MONTH, offset);
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(now.getTime());
	}

	/**
	 * 取相对于当前时间‘前’或‘后’‘N’天的日期对象｛结果日期舍去“时”、“分”、“秒”为“0时:0分:0秒”｝
	 */
	public static Date getPrevOrNextNDayDate(int offset, String pattern) {
		String formattedDate = null;
		long dateTime = 0L;
		try {
			Calendar now = Calendar.getInstance();
			now.add(Calendar.DAY_OF_MONTH, offset);

			now.set(Calendar.HOUR_OF_DAY, 0);
			now.set(Calendar.MINUTE, 0);
			now.set(Calendar.SECOND, 0);

			return now.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * return 当前时间 yyyy-MM-dd HH:mm:ss
	 */
	public static String now() {
		return format(new Date(), DATETIME);
	}

	/**
	 * return 当前日期 yyyy-MM-dd
	 */
	public static String today() {
		return format(new Date(), DATE);
	}

	public static String thisYear() {
		return format(new Date(), YEAR);
	}

//	public static void main(String[] args) {
//		System.out.println(DateUtil.thisYear());
//	}

	/**
	 * 获取当前时间所在周的星期几
	 *
	 * return
	 */
	public static String getDayInWeekName() {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);//获取周几而非一周的第几天
		if (calendar.getFirstDayOfWeek() == Calendar.SUNDAY) {//一周首日是否是周日
			dayOfWeek = dayOfWeek - 1;
			if (dayOfWeek == 0) {
				dayOfWeek = 7;
			}
		}
		return StringUtil.toUpperCaseFirstOne(DAY_IN_WEEK_ENUM.values()[dayOfWeek - 1].name().toLowerCase());
	}

	/**
	 * 取得所在时区的当前时间
	 *
	 * param zone 所在的时区
	 *              东区为正： 例 东8区：1
	 *              西区为负： 例 本8区：-8
	 * return 返回设定时区的时间
	 */
	public static Date getZoneTime(int zone) {
		/* 取得所在的时区 */
		TimeZone /*time*/defaultTimeZone;
		if (zone > 0) {
			/* 东区的时间加 */
			defaultTimeZone = TimeZone.getTimeZone("GMT+"+zone); //设置所在的时区
		} else {
			/* 西区时间差 */
			defaultTimeZone = TimeZone.getTimeZone("GMT-"+Math.abs(zone));
		}
		/* 设置时区 */
		TimeZone.setDefault(defaultTimeZone);
		/* 获取实例 */
		Calendar calendar = Calendar.getInstance();
		/* 获取Date对象 */
		return calendar.getTime();
	}

	/**
	 * 取得所在时区的当前时间
	 *
	 * param zone 所在的时区
	 *              东区为正： 例 东8区：1
	 *              西区为负： 例 西8区：-8
	 * param simpleDateFormat 例: yyyy-MM-dd
	 *                      默认为: yyyy-MM-dd HH:mm:ss
	 * return  返回设定时区的时间字符
	 */
	public static String localTime(int zone, String simpleDateFormat) {
		DateFormat format;
		if (simpleDateFormat == null || "".equals(simpleDateFormat)) {
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else {
			format = new SimpleDateFormat(simpleDateFormat);
		}
		/* 获取Date对象 */
		Date date = getZoneTime(zone);
		String dateStr = new String();
		/* 对象进行格式化，获取字符串格式的输出 */
		try {
			dateStr = format.format(date);
		} catch (Exception e) {
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateStr = format.format(date);
		}
		return dateStr;
	}

	/**
	 * Date->XMLDate格式转换
	 * param date
	 * return XMLGregorianCalendar
	 * throw
	 */
	public static XMLGregorianCalendar toXmlDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		DatatypeFactory dtFactory = null;
		try {
			dtFactory = DatatypeFactory.newInstance();
		}
		catch (DatatypeConfigurationException e) {
			return null;
		}

		XMLGregorianCalendar xmlDate = dtFactory.newXMLGregorianCalendar();
		xmlDate.setYear(cal.get(Calendar.YEAR));
		//由于Calendar.MONTH取值范围为0~11,需要加1
		xmlDate.setMonth(cal.get(Calendar.MONTH)+1);
		xmlDate.setDay(cal.get(Calendar.DAY_OF_MONTH));
		xmlDate.setHour(cal.get(Calendar.HOUR_OF_DAY));
		xmlDate.setMinute(cal.get(Calendar.MINUTE));
		xmlDate.setSecond(cal.get(Calendar.SECOND));

		return xmlDate;
	}

	/**
	 * Date->Timestamp格式转换
	 * param date
	 * return Timestamp
	 * throws
	 */
	public static Timestamp toTimestampDate(Date date) {
		return new java.sql.Timestamp(date.getTime());
	}

	/**
	 * Timestamp->Date
	 * param ts
	 * return Date
	 * throws
	 */
	public static Date toDate(Timestamp ts) {
		if(ts == null) {
			return null;
		}
		Date date = ts;
		return date;
	}

	/**
	 *
	 * param date              初始时间
	 * param schedule          周期
	 * param timeType          周期类别    [0:小时;1:天;2:周;3:月;4:季度;5:年;6:分;7:秒]
	 * return
	 */
	public static Date addTime(Object date, int schedule, int timeType) {
		Date d = parse(date);
		if(d == null) return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		switch (timeType) {
			case 0:
				calendar.add(Calendar.HOUR, schedule);break;
			case 1:
				calendar.add(Calendar.DATE, schedule);break;
			case 2:
				calendar.add(Calendar.DATE, schedule * 7);break;
			case 3:
				calendar.add(Calendar.MONTH, schedule);break;
			case 4:
				calendar.add(Calendar.MONTH, schedule * 3);break;
			case 5:
				calendar.add(Calendar.YEAR, schedule);break;
			case 6:
				calendar.add(Calendar.MINUTE, schedule);break;
			case 7:
				calendar.add(Calendar.SECOND, schedule);break;
			default:break;
		}
		return calendar.getTime();
	}



	/**
	 * 日期比较
	 * param date1
	 * param date2
	 * return date1 - date2
	 */
	public static long compileDate(Object date1, Object date2) {
		Date d1 = parse(format(parse(date1),DATE));
		Date d2 = parse(format(parse(date2),DATE));
		return d1.getTime() - d2.getTime();
	}

	/**
	 * 时间比较
	 * param date1
	 * param date2
	 * return date1 - date2
	 */
	public static long compileDateTime(Object date1, Object date2) {
		Date d1 = parse(format(parse(date1),DATETIME));
		Date d2 = parse(format(parse(date2),DATETIME));
		return d1.getTime() - d2.getTime();
	}

	/**
	 * date1是否在时间段包含date2
	 * param date1
	 * param date2
	 * return date1 - date2
	 */
	public static boolean containDate(Object date1, Object date2, int dayBefore, int dayAfter) {
		Date d1 = parse(format(parse(date1),DATE));
		Date d2 = parse(format(parse(date2),DATE));
		return addTime(d1, -dayBefore, 1).getTime() - d2.getTime() <= 0
				&& addTime(d1, dayAfter, 1).getTime() - d2.getTime() >= 0;
	}


	/**
	 * 计算指定两时间之'差'
	 * param date_1
	 * param date_2
	 * return String
	 */
	public static String substract(Date date_1, Date date_2) {
		if(date_1 == null || date_2 == null) {
			return null;
		}

    	/* 时间差单位：毫秒 */
		long delta = Math.abs(date_1.getTime() - date_2.getTime());
		long delta_days = delta / (1000 * 60 * 60 * 24);
		long delta_hours = (delta - delta_days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long delta_minutes = (delta - delta_days * (1000 * 60 * 60 * 24) - delta_hours * (1000 * 60 * 60)) / (1000 * 60);
		long delta_seconds = (delta - delta_days * (1000 * 60 * 60 * 24) - delta_hours * (1000 * 60 * 60) - delta_minutes * (1000 * 60)) / 1000;
		long delta_milliseconds = (delta - delta_days * (1000 * 60 * 60 * 24) - delta_hours * (1000 * 60 * 60) - delta_minutes * (1000 * 60) - delta_seconds * 1000) / 1;

		return delta_days+"天 "+delta_hours+"小时 "+delta_minutes+"分 "+delta_seconds+"秒 "+delta_milliseconds+"毫秒";
	}


	/**
	 * 自定义格式转换：
	 * yyyy-MM-dd'T'HH:mm:ss.SSS Z （带时区）转 yyyy-MM-dd HH:mm:ss
	 * param time (yyyy-MM-dd'T'HH:mm:ss.SSS Z )
	 * return String (yyyy-MM-dd HH:mm:ss)
	 */
	public static String date2View(String time){
		if(StringUtil.isNullorEmpty(time)) return time;
		String ff = time;
		int i = time.indexOf("Z");
		if(i != -1){
			time = time.replace("Z", " UTC");//注意是空格+UTC
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
			try {
				Date f = format.parse(time);
				ff =  DateUtil.format( f,DateUtil.DATETIME);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return ff;
	}

	/**
	 * return 当前时间 yyyyMMddHHmmss
	 */
	public static String nowCompat() {
		return format(new Date(), DATETIMECOMPACT);
	}

	/**
	 * 获取前一天起始时间
	 */
	public static String beforeStartDate(){
		Date now = new Date();
		Date before = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		//设置为前一天
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		//得到前一天的时间
		before = calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String beforeStartDate = sdf.format(before);
		beforeStartDate = beforeStartDate+" 00:00:00";
		return beforeStartDate;
	}

	/**
	 * 获取前一天结束时间
	 */
	public static String beforeEndDate(){
		Date now = new Date();
		Date before = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		//设置为前一天
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		//得到前一天的时间
		before = calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String beforeEndDate = sdf.format(before);
		beforeEndDate = beforeEndDate.substring(0,10)+" 23:59:59";
		return beforeEndDate;
	}

	/**
	 * 获取当天零点时间
	 */
	public static String getZeroTime(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (DateUtil.format(cal.getTime(),DateUtil.DATETIME));
	}

	/**
	 * 获取当天结束时间
	 */
	public static String getLastTime(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 59);
		return (DateUtil.format(cal.getTime(),DateUtil.DATETIME));
	}

	/**
	 * 日期是否违法，格式 "yyyy-MM-dd HH:mm:ss"
	 * 年 月 日 不能为空
	 * 时间可为空，为空时则为 "00:00:00"
	 */
	public static boolean isIllegalDateTime(String year, Integer month, Integer day, String time) {
		if(year == null || month == null || day == null)
			return true;
		String _triggerMonth = month < 10? "0" + month: month + "";
		String _triggerDay = day < 10? "0" + day: day + "";
		String _time = StringUtil.isNullorEmpty(time)? "00:00:00": time;
		String dateStr = year + "-" + _triggerMonth + "-" + _triggerDay + " " + _time;
		String dateFormatStr = DateUtil.format(DateUtil.parse(dateStr));
		if(dateFormatStr == null)
			return true;
		return !dateStr.equals(dateFormatStr);
	}

	/**
	 * 时间是否违法，格式 "HH:mm:ss"
	 */
	public static boolean isIllegalTime(String time) {
		if(StringUtil.isNullorEmpty(time))
			return true;
		String todayTime = today() + " " + time;
		String dateFormatStr = DateUtil.format(DateUtil.parse(todayTime));
		if(dateFormatStr == null)
			return true;
		return !todayTime.equals(dateFormatStr);
	}

	/**
	 * 根据月份数字，转换格式
	 * 1 ==> 01
	 * 10 ==> 10
	 */
	public static String getFormatMonth(String month){
		if(StringUtils.isEmpty(month)){
			return "null";
		}
		String m = month + "";
		int mSize = m.length();
		if(mSize>1){
			return m;
		}else{
			m = "0" + m;
			return m;
		}

	}

	/**
	 * 根据日期数字，转换格式
	 * 1 ==> 01
	 * 10 ==> 10
	 */
	public static String  getFormatDay(String day){
		if(StringUtils.isEmpty(day)){
			return "null";
		}
		String d = day + "";
		int dSize = d.length();
		if(dSize>1){
			return d;
		}else{
			d = "0" + d;
			return d;
		}
	}

	/**
	 * 根据月份，日期，转换格式
	 * 1,1 ==》 01-01
	 * 10，20 ==》 10-20
	 */
	public static String getFormatMonthDay(String month,String day){
		if(StringUtils.isEmpty(month) || StringUtils.isEmpty(day)){
			return "null";
		}
		String M = getFormatMonth(month);
		String D = getFormatMonth(day);
		return M + "-" + D;
	}

	/**
	 * 根据时间转换对应的cron时间格式：
	 * 01:30 ==> 0 30 1 * * ?
	 */
	public static String getCronDate(String t){
		if(StringUtils.isEmpty(t)){
			return "null";
		}
		String[] strs = t.trim().split(":");
		String tmp = "0";
		for(String s:strs){
			if(Integer.parseInt(s.substring(0,1))>0){
				tmp += " ";
				tmp += s;
			}else{
				tmp += " ";
				tmp += s.substring(1,2);
			}
		}
		tmp += " * * ?";
		return tmp;
	}

	/**
	 * 判断某时间[targetTime]是否在一段时间区间内[date1,date2]
	 */
	public static boolean containTime(Object date1,Object date2,Object targetTime){
		boolean t1 = comTime(date1,targetTime);
		boolean t2 = comTime(date2,targetTime);

		if(!t1 && t2){
			return true;
		}
		return false;
	}

	/**
	 * 时间比较
	 * param date1
	 * param date2
	 * return boolean
	 */
	public static boolean comTime(Object date1, Object date2) {
		Date d1 = parse(date1);
		Date d2 = parse(date2);
		long t = d1.getTime() - d2.getTime();
		if(t>=0){
			return true;
		}else{
			return false;
		}
	}
}