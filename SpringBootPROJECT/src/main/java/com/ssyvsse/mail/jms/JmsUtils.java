package com.ssyvsse.mail.jms;

import java.io.File;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author llb
 *
 * @Date 2018年3月21日 下午7:44:04
 */
@Component
public class JmsUtils {

	@Autowired
	private JavaMailSenderImpl mailSender;

	/**
	 * 发送包含简单文本的邮件
	 * @param sendTo 发送给
	 * @param from 来自
	 * @param subject 标题
	 * @param text 文本
	 * @throws MailException 异常
	 */
	public void sendTxtMail(String[] sendTo, String from, String subject, String text) throws MailException {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		// 设置收件人，寄件人
		simpleMailMessage.setTo(sendTo);
		simpleMailMessage.setFrom(from);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);
		// simpleMailMessage.setBcc(bcc);
		// simpleMailMessage.setCc(cc);
		simpleMailMessage.setSentDate(new Date());
		// simpleMailMessage.setReplyTo(replyTo);
		// 发送邮件
		mailSender.send(simpleMailMessage);
	}

	/**
	 * 发送包含HTML文本的邮件
	 * @param cc 抄送
	 * @param sendTo 发送给
	 * @param from 来自
	 * @param subject 标题
	 * @param text 文本
	 * @param imagePath 图片路径
	 * @throws AddressException 地址异常
	 */
	public void sendHtmlMail(String cc, String[] sendTo, String from, String subject, String text, String html)
			throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		// 第一个参数是接收者的类型，第二个参数是接收者</br>
		// 接收者类型可以是Message.RecipientType.TO，</br>
		// Message.RecipientType.CC</br>
		// Message.RecipientType.BCC，TO表示主要接收人，CC表示抄送人，BCC表示秘密抄送人。</br>
		if (cc != null && !"".equals(cc)) {
			mimeMessage.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(cc));
		}
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(sendTo);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setSubject(subject);

		// 启用html
		mimeMessageHelper.setText(html, true);
		// 发送邮件
		mailSender.send(mimeMessage);
	}

	/**
	 * 发送包含内嵌图片的邮件<br>
	 * 暂不可用<br>
	 * 信用度不够<br>
	 * @param cc 抄送
	 * @param sendTo 发送给
	 * @param from 来自
	 * @param subject 标题
	 * @param text 文本
	 * @param imagePath 图片路径
	 * @throws AddressException 地址异常
	 * @throws MessagingException 发送消息异常
	 */
	public void sendAttachedImageMail(String cc, String[] sendTo, String from, String subject, String text,
			String imagePath) throws AddressException, MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		if (cc != null && !"".equals(cc)) {
			mimeMessage.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(cc));
		}
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(sendTo);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setSubject(subject);

		StringBuilder sb = new StringBuilder();
		sb.append("<html><head></head>");
		sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p>");
		// cid为固定写法，imageId指定一个标识
		sb.append("<img src=\"cid:imageId\" /></body>");
		sb.append("</html>");

		// 启用html
		mimeMessageHelper.setText(sb.toString(), true);

		// 设置imageId
		FileSystemResource img = new FileSystemResource(new File(imagePath));
		mimeMessageHelper.addInline("imageId", img);
		// 发送邮件
		mailSender.send(mimeMessage);
	}

	/**
	 * 
	 * 发送包含附件的邮件
	 * @param cc 抄送
	 * @param sendTo 发送给
	 * @param from 来自
	 * @param subject 标题
	 * @param text 文本
	 * @param imagePath 图片路径
	 * @throws AddressException 地址异常
	 * @throws MessagingException 发送消息异常
	 */
	public void sendAttendedFileMail(String cc, String[] sendTo, String from, String subject, String text,
			String imagePath) throws AddressException, MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		if (cc != null && !"".equals(cc)) {
			mimeMessage.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(cc));
		}
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(sendTo);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setSubject(subject);

		StringBuilder sb = new StringBuilder();
		sb.append("<html><head></head>");
		sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p></body>");
		sb.append("</html>");

		// 启用html
		mimeMessageHelper.setText(sb.toString(), true);
		// 设置附件
		FileSystemResource img = new FileSystemResource(new File(imagePath));
		mimeMessageHelper.addAttachment("image.jpg", img);

		// 发送邮件
		mailSender.send(mimeMessage);
	}
}
