package com.ssyvsse.beanLiftCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author llb
 *
 * @Date 2018年3月24日 下午7:37:58
 */
@Configuration
public class MyConfig {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public BeanWayService beanWayService() {
		return new BeanWayService();
	}

	@Bean
	public JSR250WayService jSR250WayService() {
		return new JSR250WayService();
	}

}
