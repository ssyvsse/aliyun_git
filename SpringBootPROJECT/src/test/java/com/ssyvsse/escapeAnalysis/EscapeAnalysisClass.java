package com.ssyvsse.escapeAnalysis;

/**
 * @author llb
 *
 * @Date 2018年3月24日 上午8:38:57
 */
public class EscapeAnalysisClass {

	public static B b;

	public void globalVariablePointerEscape(){
		b = new B();
	}
	
	public B methodPointerEscape(){
		return new B();
	}
	
	public void instancePassPointerEscape(){
		methodPointerEscape().printClassName(null);
	}
}

class B {
	public void printClassName(G g) {
		System.out.println(g.getClass().getName());
	}
}

