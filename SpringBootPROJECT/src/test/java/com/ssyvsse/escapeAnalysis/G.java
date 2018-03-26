package com.ssyvsse.escapeAnalysis;
/**
 * @author llb
 *
 * @Date 2018年3月24日 上午8:39:50 
 */
public class G {

	public static B b;
	
	public void globalVariablePointerEscape(){
		b = new B();
	}
	
	public B methodPointerEscape(){
		return new B();
	}
	
	public void instancePassPointerEscape(){
		methodPointerEscape().printClassName(this);
	}
}
