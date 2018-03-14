package com.ssyvsse.configuration;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author llb
 *
 * @Date 2018年3月14日 上午8:06:56
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener {

	private ArrayList<String> sessionList;

	@Override
	public void requestDestroyed(ServletRequestEvent event) {

	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		sessionList = (ArrayList<String>) event.getServletContext().getAttribute("sessionList");
		HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
		if (sessionList == null) {
			sessionList = new ArrayList<String>();
		}
		if ("/".equalsIgnoreCase(request.getRequestURI())) {
			String sessionId = request.getSession().getId();
			boolean sessionExist = true;
			for (String session : sessionList) {
				if (session.equalsIgnoreCase(sessionId)) {
					sessionExist = false;
				}
			}
			if (sessionExist) {
				sessionList.add(sessionId);
			}
			event.getServletContext().setAttribute("sessionList", sessionList);
			event.getServletContext().setAttribute("count", sessionList.size());
		}
	}

}
