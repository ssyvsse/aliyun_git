package com.ssyvsse.pojo;

/**
 * @author llb
 *
 * @Date 2018年3月24日 上午11:38:46
 */
public class User {

	private String name;

	private Integer age;

	public User() {

	}

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}
