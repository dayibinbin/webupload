package com.qiigame.base;

public class BaseResult implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3733887360435743083L;
	public int statusCode;
	public String message;
	public boolean success;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
