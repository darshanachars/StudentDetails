package com.example.demo.exceptionHandler;

public class AllObjectsException extends RuntimeException {
	String resource;
	
	public AllObjectsException(String resource) {
		super(String.format("%s is empty",resource));
		this.resource = resource;
		
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
	
	
}
