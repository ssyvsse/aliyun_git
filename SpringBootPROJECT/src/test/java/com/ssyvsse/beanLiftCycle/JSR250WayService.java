package com.ssyvsse.beanLiftCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author llb
 *
 * @Date 2018年3月24日 下午7:36:14 
 */
public class JSR250WayService {

	@PostConstruct
	public void init(){
		System.out.println("JSR250WayService init.");
	}
	
	public JSR250WayService(){
		System.out.println("JSR250WayService invocat Construct Method.");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("JSR250WayService destroy.");
	}
	
}
