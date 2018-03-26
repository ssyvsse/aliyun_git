package com.ssyvsse.bitCalVSMathCal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * @author llb
 *
 * @Date 2018年3月25日 上午7:42:48 
 */
public class BitCalVSMathCal {

	public static void main(String[] args) {
//		long start = System.currentTimeMillis();
		final int N = 100000000;
//		long a = 100000;
//		for (int i = 0; i < N; i++) {
//			a*=2;
//			a/=2;
//		}
//		System.out.println(a);
//		System.out.println(System.currentTimeMillis()-start);
//		start = System.currentTimeMillis();
//		for (int i = 0; i < N; i++) {
//			a<<=1;
//			a>>=1;
//		}
//		System.out.println(a);
//		System.out.println(System.currentTimeMillis()-start);
		
//		long start = System.currentTimeMillis();
//		int a = 99999;
//		for (int i = 0; i < N; i++) {
//			a*=2;
//			a/=2;
//		}
//		System.out.println(System.currentTimeMillis()-start);
//		start = System.currentTimeMillis();
//		for (int i = 0; i < N; i++) {
//			a<<=1;
//			a>>=1;
//		}
//		System.out.println(System.currentTimeMillis()-start);
		
//		System.out.println(0B001110);
		
		String[] strArr = new String[]{"1","2","3","4","5"};
		System.out.println(Arrays.asList(strArr).contains("5"));
		Integer[] intArr = new Integer[]{1,2,3,4,5};
		System.out.println(Arrays.asList(intArr).contains(5));
		Character[] charArr = new Character[]{'a','b','c','d','e'};
		System.out.println(Arrays.asList(charArr).contains('b'));
		List<String> linkList = new LinkedList<String>();
		linkList.add("a");
		linkList.add("5");
		linkList.add("6");
		linkList.add("7");
		linkList.add("s");
		linkList.add("fg");
		linkList.add("vb");
		linkList.add("g");
		linkList.add("n");
		System.out.println(linkList);
		Iterator<String> it = linkList.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	private final List<String> strList = new ArrayList<String>();
	
	private static final String[] EMPTY_STR_ARRAY = new String[0];
	
	public String[] getStringList(){
		return strList.toArray(EMPTY_STR_ARRAY);
	}
	
	public List<String> getStrList(){
		if(strList.isEmpty()){
			return Collections.emptyList();
		}else{
			return new ArrayList<String>(strList);
		}
	}
}
