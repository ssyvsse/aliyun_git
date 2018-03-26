package com.ssyvsse.staticVSinstance;
/**
 * @author llb
 *
 * @Date 2018年3月25日 上午7:29:44 
 */
public class StaticVSInstance {

	public static void staticMethod(){
		
	}
	
	public void instanceMethod(){
		
	}
	
	public static void main(String[] args) {
		final Long N = 1000000000L;
		long start = System.currentTimeMillis();
//		for (int i = 0; i < N; i++) {
//			StaticVSInstance.staticMethod();
//		}
//		System.out.println(System.currentTimeMillis()-start);
//		start = System.currentTimeMillis();
		StaticVSInstance svs = new StaticVSInstance();
		for (int i = 0; i < N; i++) {
			svs.instanceMethod();
		}
		System.out.println(System.currentTimeMillis()-start);
		
	}
	
}
