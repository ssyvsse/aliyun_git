package com.ssyvsse.beanLiftCycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author llb
 *
 * @Date 2018年3月24日 下午7:39:19 
 */
public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		BeanWayService beanWayService = context.getBean(BeanWayService.class);
		JSR250WayService jsr250WayService = context.getBean(JSR250WayService.class);
		context.close();
	}
	
}
