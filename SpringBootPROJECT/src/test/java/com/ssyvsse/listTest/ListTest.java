package com.ssyvsse.listTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

/**
 * @author llb
 *
 * @Date 2018年3月26日 上午10:09:10 
 */
public class ListTest {

	
	public static void main(String[] args) {
		List list1 = new ArrayList();
		List list2 = new LinkedList();
		System.out.println(list1 instanceof RandomAccess);
		System.out.println(list2 instanceof RandomAccess);
	}
	
	
}
