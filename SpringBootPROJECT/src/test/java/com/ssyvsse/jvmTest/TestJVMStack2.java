package com.ssyvsse.jvmTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssyvsse.SpringBootApp;

/**
 * 测试栈深度
 * 
 * @author llb
 *
 * @Date 2018年3月24日 上午7:56:57 
 */
@SpringBootTest(classes=SpringBootApp.class)
@RunWith(SpringRunner.class)
public class TestJVMStack2 {

	private int count = 0;
	
	public void recursion(long a ,long b,long c)throws InterruptedException{
		long d=0,e=0,f=0;
		count ++;
		recursion(a,b,c);
	}
	
	public void testStack(){
		try{
			recursion(1L,2L,3L);
		}catch(Throwable e){
			System.out.println("deep of stack is " + count);
			e.printStackTrace();
		}
	}
	
	@Test
	public void testStackOfFlow(){
		TestJVMStack2 ts = new TestJVMStack2();
		ts.testStack();
	}
}
