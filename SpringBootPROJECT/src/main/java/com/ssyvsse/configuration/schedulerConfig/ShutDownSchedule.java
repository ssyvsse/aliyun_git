package com.ssyvsse.configuration.schedulerConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author llb
 *
 * @Date 2018年3月25日 上午11:23:57
 */
@WebListener
public class ShutDownSchedule implements ServletContextListener {

	private Logger logger = LoggerFactory.getLogger(ShutDownSchedule.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.error("---应用开启---");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.error("---应用关闭---");
	}

}
