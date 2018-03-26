package com.ssyvsse.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author llb
 *
 * @Date 2018年3月24日 下午7:55:22 
 */
public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
		ListService bean = ctx.getBean(ListService.class);
		System.out.println(bean.showListCmd());
		ctx.close();
	}
	
}
