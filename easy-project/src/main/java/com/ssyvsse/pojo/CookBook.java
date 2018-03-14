package com.ssyvsse.pojo;

import java.util.List;

/**
 * @author llb
 *
 * @Date 2018年3月13日 下午9:06:07
 */
public class CookBook {

	private Integer id;

	private String title;

	private String imtro;

	private String ingredients;

	private String burden;

	private String album;

	private Integer click_rate;

	private List<CookStep> cookSteps;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImtro() {
		return imtro;
	}

	public void setImtro(String imtro) {
		this.imtro = imtro;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getBurden() {
		return burden;
	}

	public void setBurden(String burden) {
		this.burden = burden;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Integer getClick_rate() {
		return click_rate;
	}

	public void setClick_rate(Integer click_rate) {
		this.click_rate = click_rate;
	}

	public List<CookStep> getCookSteps() {
		return cookSteps;
	}

	public void setCookSteps(List<CookStep> cookSteps) {
		this.cookSteps = cookSteps;
	}

}
