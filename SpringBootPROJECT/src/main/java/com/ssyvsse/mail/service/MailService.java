package com.ssyvsse.mail.service;

import javax.servlet.http.HttpServletRequest;

import com.ssyvsse.base.entity.JsonResult;

/**
 * @author llb
 *
 * @Date 2018年3月23日 上午7:48:45
 */
public interface MailService {

	/**
	 * springboot mail 发送邮件
	 * 
	 * @param sendTo
	 * @param from
	 * @param subject
	 * @param text
	 * @param request
	 * @return
	 */
	public JsonResult sendSimpleMail(String[] sendTo, String from, String subject, String text,
			HttpServletRequest request);

	/**
	 * javax.mail发送邮件
	 * 
	 * @param sendTo
	 * @param from
	 * @param subject
	 * @param text
	 * @param request
	 * @return
	 */
	public JsonResult javaxSendSimpleMail(String[] sendTo, String from, String subject, String text,
			HttpServletRequest request);

}
