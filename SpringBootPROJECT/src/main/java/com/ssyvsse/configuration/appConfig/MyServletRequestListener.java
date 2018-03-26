package com.ssyvsse.configuration.appConfig;

import java.util.ArrayList;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {

	private ArrayList<String> sessionList;

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
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
