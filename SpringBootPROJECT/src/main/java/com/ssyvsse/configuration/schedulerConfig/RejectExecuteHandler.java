package com.ssyvsse.configuration.schedulerConfig;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author llb
 *
 * @Date 2018年3月23日 上午11:55:29
 */
@Component
public class RejectExecuteHandler implements RejectedExecutionHandler {

	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
		logger.error("executor.getCompletedTaskCount()="+executor.getCompletedTaskCount());
		logger.error("executor.getTaskCount()="+executor.getTaskCount());
		logger.error(runnable.toString() + " : has been rejected");
	}

}
