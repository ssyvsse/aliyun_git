package com.ssyvsse.configuration;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author llb
 *
 * @Date 2018年3月14日 上午8:01:19
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

	private Logger logger = LoggerFactory.getLogger(MySessionListener.class);

	private Integer count = 0;

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		logger.info("创建session==" + session.getId());
		ServletContext application = session.getServletContext();
		ArrayList<String> sessionList = (ArrayList<String>) application.getAttribute("sessionList");
		if (sessionList != null) {
			count = sessionList.size();
		}
		application.setAttribute("count", count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		logger.info("销毁session==" + session.getId());
		ServletContext application = session.getServletContext();
		ArrayList<String> sessionList = (ArrayList<String>) application.getAttribute("sessionList");
		if (sessionList != null) {
			Iterator<String> itertor = sessionList.iterator();
			while (itertor.hasNext()) {
				String sessionid = itertor.next();
				if (sessionid.equalsIgnoreCase(session.getId())) {
					itertor.remove();
				}
			}
		}
		application.setAttribute("count", sessionList != null ? sessionList.size() : 0);
	}

}
