package com.dreamworks.sms.resouce;

public class JsonResult {

	private String code;
    private String message;
    private Object data;
    
	public JsonResult(ResultCode code, String message) {
		super();
		this.setCode(code);
		this.setMessage(message);
	}

	public JsonResult(ResultCode code, String message, Object data) {
		super();
		this.setCode(code);
		this.setData(data);
		this.setMessage(message);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(ResultCode code) {
		this.code = code.val();
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
}
