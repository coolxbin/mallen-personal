package com.huangzb.test.beancoper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	// JDK中的日期格式（年-月-日）
	public final static String jdkDateFormat = "yyyy-MM-dd";

	// JDK中的日期时间格式（年-月-日 时:分:秒）
	public final static String jdkDateTimeFormat = "yyyy-MM-dd HH:mm:ss";

	// 字符串转换为日期
	public static Date strToDate(String strDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(jdkDateFormat);
		Date date = null;
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return date;
	}

	// 字符串转换为日期时间
	public static Date strToDateTime(String strDateTime) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
				jdkDateTimeFormat);
		Date dateTime = null;
		try {
			dateTime = dateTimeFormat.parse(strDateTime);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return dateTime;
	}

	// 日期转换为字符串
	public static String dateToStr(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(jdkDateFormat);
		String strDate = dateFormat.format(date);
		return strDate;
	}

	// 日期时间转换为字符串
	public static String dateTimeToStr(Date date) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
				jdkDateTimeFormat);
		String strDateTime = dateTimeFormat.format(date);
		return strDateTime;
	}
}
