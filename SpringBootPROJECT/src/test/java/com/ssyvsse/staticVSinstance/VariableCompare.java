package com.ssyvsse.staticVSinstance;
/**
 * @author llb
 *
 * @Date 2018年3月25日 上午7:39:13 
 */
public class VariableCompare {

	public static int b = 0;
	
	public static void main(String[] args) {
		int a = 0;
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			a++;
		}
		System.out.println(System.currentTimeMillis()-start);
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			b++;
		}
		System.out.println(System.currentTimeMillis()-start);
	}
	
}
