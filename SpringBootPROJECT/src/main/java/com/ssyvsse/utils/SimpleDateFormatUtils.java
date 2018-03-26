package com.ssyvsse.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author llb
 *
 * @Date 2018年3月24日 上午9:04:52
 */
public final class SimpleDateFormatUtils {

	public static final String DATE_PARTEN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 线程安全转换 String -> Date
	 */
	public static Date safeParseDate(String dateStr) {
		try {
			return getFormat().parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 线程安全格式化 Date -> String
	 */
	public static String safeFormatDate(Date date) {
		return getFormat().format(date);
	}

	private static int threadPoolCount = 1;
	
	/**
	 * 借助ThreadLocal完成对每个线程第一次调用时初始化SimpleDateFormat对象
	 */
	private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
		protected synchronized SimpleDateFormat initialValue() {
			System.out.println("init the ThreadPool count=" + threadPoolCount++);
			return new SimpleDateFormat(DATE_PARTEN);
		}
	};

	/**
	 * 获取当前线程中的安全SimpleDateFormat对象
	 */
	public static DateFormat getFormat() {
		return (DateFormat) threadLocal.get();
	}

}
