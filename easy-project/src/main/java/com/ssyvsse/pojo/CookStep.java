package com.ssyvsse.pojo;

/**
 * @author llb
 *
 * @Date 2018年3月14日 下午9:07:50
 */
public class CookStep {

	private Integer cookBookId;

	private int sort;

	private String img;

	private String step;

	public Integer getCookBookId() {
		return cookBookId;
	}

	public void setCookBookId(Integer cookBookId) {
		this.cookBookId = cookBookId;
	}

	public int getSort() {
		this.sort = Integer.parseInt(this.step.substring(0, step.indexOf(".")));
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

}
