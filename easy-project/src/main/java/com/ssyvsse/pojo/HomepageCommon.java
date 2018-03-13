package com.ssyvsse.pojo;

/**
 * @author llb
 *
 * @Date 2018年3月13日 下午8:06:10
 */
public class HomepageCommon {

	private Integer id;

	private String name;

	private String description;

	private Integer parentid;

	private String url;

	private String type;

	private String image;

	private Integer sort;

	private String seodescribe;

	private String seokeywords;

	private String seotitle;

	private String comment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getSeodescribe() {
		return seodescribe;
	}

	public void setSeodescribe(String seodescribe) {
		this.seodescribe = seodescribe;
	}

	public String getSeokeywords() {
		return seokeywords;
	}

	public void setSeokeywords(String seokeywords) {
		this.seokeywords = seokeywords;
	}

	public String getSeotitle() {
		return seotitle;
	}

	public void setSeotitle(String seotitle) {
		this.seotitle = seotitle;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "HomepageCommon [id=" + id + ", name=" + name + ", description=" + description + ", parentid=" + parentid
				+ ", url=" + url + ", type=" + type + ", image=" + image + ", sort=" + sort + ", seodescribe="
				+ seodescribe + ", seokeywords=" + seokeywords + ", seotitle=" + seotitle + ", comment=" + comment
				+ "]";
	}

}
