package com.ssyvsse.mail.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.ssyvsse.base.entity.JsonResult;
import com.ssyvsse.mail.jms.JmsUtils;
import com.ssyvsse.mail.jxms.JavaxMailUtils;
import com.ssyvsse.mail.service.MailService;

/**
 * @author llb
 *
 * @Date 2018年3月23日 上午10:08:28
 */
@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JmsUtils jmsUtils;

	@Autowired
	private JavaxMailUtils javaxMailUtils;

	@Override
	public JsonResult sendSimpleMail(String[] sendTo, String from, String subject, String text,
			HttpServletRequest request) {
		if (sendTo == null || sendTo.length == 0) {
			return JsonResult.failure("请输入接收人");
		}
		if (from == null || "".equals(from)) {
			return JsonResult.failure("请输入发送人");
		}
		if (subject == null || "".equals(subject)) {
			return JsonResult.failure("请输入邮件标题");
		}
		if (text == null || "".equals(text)) {
			return JsonResult.failure("请输入邮件正文");
		}
		try {
			jmsUtils.sendTxtMail(sendTo, from, subject, text);
		} catch (MailException e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}

	@Override
	public JsonResult javaxSendSimpleMail(String[] sendTo, String from, String subject, String text,
			HttpServletRequest request) {
		if (sendTo == null || "".equals(sendTo)) {
			return JsonResult.failure("请输入接收人");
		}
		if (from == null || "".equals(from)) {
			return JsonResult.failure("请输入发送人");
		}
		if (subject == null || "".equals(subject)) {
			return JsonResult.failure("请输入邮件标题");
		}
		if (text == null || "".equals(text)) {
			return JsonResult.failure("请输入邮件正文");
		}
		try {
			javaxMailUtils.sendMail(subject, from, text, sendTo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonResult.success();
	}

}
