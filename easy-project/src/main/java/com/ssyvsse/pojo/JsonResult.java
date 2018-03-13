package com.ssyvsse.pojo;

/**
 * @author llb
 *
 * @Date 2018年3月13日 下午9:01:00
 */
public class JsonResult {

	private Integer code;

	private String message;

	private Object data;

	public JsonResult(Integer code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static JsonResult success(Object object) {
		return new JsonResult(0, "操作成功", object);
	}

	public static JsonResult success(String message, Object object) {
		return new JsonResult(0, message, object);
	}

	public static JsonResult failure(String message) {
		return new JsonResult(-1, message, null);
	}

}
