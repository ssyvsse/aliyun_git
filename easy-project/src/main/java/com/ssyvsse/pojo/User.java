package com.ssyvsse.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author llb
 *
 * @Date 2018年3月5日 下午11:15:00
 */
@Entity
@Table(name = "tb_user")
@DynamicInsert
@DynamicUpdate
public class User implements Serializable {

	private static final long serialVersionUID = 1557323375682565514L;

	private Integer id;

	private String username;

	private String password;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
