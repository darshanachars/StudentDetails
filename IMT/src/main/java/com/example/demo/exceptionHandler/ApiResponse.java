package com.example.demo.exceptionHandler;

public class ApiResponse {
	String msg;
	boolean status;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public ApiResponse(String msg, boolean status) {
		
		this.msg = msg;
		this.status = status;
	}
	
}
