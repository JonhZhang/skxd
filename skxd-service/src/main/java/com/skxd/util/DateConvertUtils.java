package com.skxd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateConvertUtils {
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static String format(Date date) {
		return format(date, DATE_FORMAT);
	}

	public static String formatDateTime(Date date) {
		return format(date, DATE_TIME_FORMAT);
	}

	public static String format(Date date, String format) {
		if (date == null)
			return null;

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static Date formatToDate(Date date, String format) {
		if (date == null)
			return null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String s = dateFormat.format(date);
		Date t = null;
		try {
			t = dateFormat.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return t;
	}

	public static Date parse(String date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		if (date == null || date.trim() == "")
			return null;
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static long diffMinutes(Date t1, Date t2) {
		long tms1 = t1.getTime();
		long tms2 = t2.getTime();

		return (tms2 - tms1) / (1000 * 60);
	}

	public static long diffDayes(Date t1, Date t2) {
		long tms1 = t1.getTime();
		long tms2 = t2.getTime();

		return (tms2 - tms1) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 判断某一时间是否为今天的某一时间
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		String now = sdf.format(new Date());
		if (dateStr.equals(now)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 求开始截至日期之间的天数差.
	 * 
	 * @param d1
	 *            开始日期
	 * @param d2
	 *            截至日期
	 * @return 返回相差天数
	 */
	public static int getDaysInterval(Date d1, Date d2) {
		if (d1 == null || d2 == null)
			return 0;
		Date[] d = new Date[2];
		d[0] = d1;
		d[1] = d2;
		Calendar[] cal = new Calendar[2];
		for (int i = 0; i < cal.length; i++) {
			cal[i] = Calendar.getInstance();
			cal[i].setTime(d[i]);
			cal[i].set(Calendar.HOUR_OF_DAY, 0);
			cal[i].set(Calendar.MINUTE, 0);
			cal[i].set(Calendar.SECOND, 0);
		}
		long m = cal[0].getTime().getTime();
		long n = cal[1].getTime().getTime();
		int ret = (int) Math.abs((m - n) / 1000 / 3600 / 24);
		return ret;
	}

	/**
	 * 
	 * Description:指定日期加或减days天
	 * 

	 * @return
	 * @since：2007-12-17 下午03:47:12
	 */
	public static Date addDay(Date date1, int days) {
		Calendar date = Calendar.getInstance();
		date.setTime(date1);
		date.add(Calendar.DAY_OF_YEAR, days);
		return date.getTime();
	}

	public static Date addMonth(Date date1, int num) {
		Calendar date = Calendar.getInstance();
		date.setTime(date1);
		date.add(Calendar.MONTH, num);
		return date.getTime();
	}
	public static Date addMinute(Date date1, int minute) {
		Calendar date = Calendar.getInstance();
		date.setTime(date1);
		date.add(Calendar.MINUTE, minute);
		return date.getTime();
	}

	/**
	 * 获取某天的开始时间
	 * 
	 * @return
	 */
	public static Date getDateStart(Date date) {
		Calendar start = new GregorianCalendar();
		start.setTime(date);
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);
		start.set(Calendar.MILLISECOND, 0);
		return start.getTime();
	}

	/**
	 * 获取某天的结束时间
	 * 
	 * @return
	 */
	public static Date getDateEnd(Date date) {
		Calendar end = new GregorianCalendar();
		end.setTime(date);
		end.set(Calendar.HOUR_OF_DAY, 23);
		end.set(Calendar.MINUTE, 59);
		end.set(Calendar.SECOND, 59);
		end.set(Calendar.MILLISECOND, 999);
		return end.getTime();
	}

	public static void main(String[] args) {
		Date date = DateConvertUtils.addMonth(new Date(),0-1);
		System.out.println(DateConvertUtils.format(date));
	}
}
