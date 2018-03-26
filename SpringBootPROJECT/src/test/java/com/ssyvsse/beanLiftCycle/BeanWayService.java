package com.ssyvsse.beanLiftCycle;
/**
 * @author llb
 *
 * @Date 2018年3月24日 下午7:34:50 
 */
public class BeanWayService {

	public void init(){
		System.out.println("BeanWayService init.");
	}
	
	public BeanWayService(){
		System.out.println("BeanWayService invocat Construct Method.");
	}
	
	public void destroy(){
		System.out.println("BeanWayService destroy.");
	}
	
}
