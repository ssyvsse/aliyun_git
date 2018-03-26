package com.ssyvsse.configuration.schedulerConfig;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程池配置
 * 
 * @author llb
 *
 * @Date 2018年3月23日 上午11:53:56
 */
@EnableAsync
@Configuration
public class SchedulerConfig extends AsyncConfigurerSupport {

	@Autowired
	private RejectExecuteHandler rejectExecuteHandler;

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setAllowCoreThreadTimeOut(false);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(10);
		executor.setRejectedExecutionHandler(rejectExecuteHandler);
		executor.setThreadNamePrefix("thread-");
		//executor.setKeepAliveSeconds(1000*30);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.initialize();
		return executor;
	}
}
