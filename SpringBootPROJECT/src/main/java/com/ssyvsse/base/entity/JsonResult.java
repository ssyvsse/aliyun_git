package com.ssyvsse.base.entity;

/**
 * @author llb
 *
 * @Date 2018年3月23日 上午10:10:19
 */
public class JsonResult {

	private Integer code;

	private String message;

	private Object object;

	private JsonResult(Integer code, String message, Object object) {
		this.code = code;
		this.message = message;
		this.object = object;
	}

	public static JsonResult success() {
		return new JsonResult(0, "操作成功", null);
	}

	public static JsonResult success(Object object) {
		return new JsonResult(0, "操作成功", object);
	}

	public static JsonResult success(String message, Object object) {
		return new JsonResult(0, message, object);
	}

	public static JsonResult failure() {
		return new JsonResult(-1, "操作失败", null);
	}

	public static JsonResult failure(String message) {
		return new JsonResult(-1, message, null);
	}

	public static JsonResult failureWithData(String message, Object object) {
		return new JsonResult(-1, message, object);
	}

	public static JsonResult failure(Integer code, String message) {
		return new JsonResult(code, message, null);
	}

	public static JsonResult JsonOKDataWithCode(Integer code, String message, Object object) {
		return new JsonResult(code, message, object);
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

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "JsonResult [code=" + code + ", message=" + message + ", object=" + object + "]";
	}

}
