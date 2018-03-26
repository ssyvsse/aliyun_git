package com.ssyvsse.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author llb
 *
 * @Date 2018年3月24日 下午7:48:27
 */
@Configuration
public class MyConfig {

	@Bean
	@Conditional(value = LinuxCondition.class)
	public ListService linuxListService() {
		return new LinuxListService();
	}

	@Bean
	@Conditional(value = WindowsCondition.class)
	public ListService windowsListService() {
		return new WindowsListService();
	}

}
