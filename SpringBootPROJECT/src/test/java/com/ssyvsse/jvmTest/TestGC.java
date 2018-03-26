package com.ssyvsse.jvmTest;
/**
 * @author llb
 *
 * @Date 2018年3月24日 上午8:22:49 
 */
public class TestGC {

	public static void test1(){
		byte[] a = new byte[6*1024*1024];
		System.gc();
		System.out.println("first explict go over.");
	}
	
	public static void main(String[] args) {
		TestGC.test1();
	}
}
