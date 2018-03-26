package com.ssyvsse.mail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssyvsse.base.entity.JsonResult;
import com.ssyvsse.mail.service.MailService;

/**
 * @author llb
 *
 * @Date 2018年3月23日 上午7:45:34
 */
@RestController
@RequestMapping("/mail")
public class MailController {

	@Autowired
	private MailService mailService;

	@GetMapping("/sendSimpleMail")
	public JsonResult index(String[] sendTo, String from, String subject, String text, HttpServletRequest request) {
		return mailService.sendSimpleMail(sendTo, from, subject, text, request);
	}

	@GetMapping("/javaxSendSimpleMail")
	public JsonResult index(String[] sendTo, String from, String subject, String text, HttpServletRequest request,HttpSession session) {
		return mailService.javaxSendSimpleMail(sendTo, from, subject, text, request);
	}

}
