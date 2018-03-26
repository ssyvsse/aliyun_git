package com.ssyvsse.utils;

import java.util.Calendar;

/**
 * @author llb
 *
 * @Date 2018年3月24日 上午9:31:29
 */
public final class DateUtils {

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static String getNow() {
		return SimpleDateFormatUtils.getFormat().format(Calendar.getInstance().getTime());
	}
}
