package com.example.demo.exceptionHandler;

public class ResourceNotFound extends RuntimeException{
	String resource;
	String field;
	long value;
	public ResourceNotFound(String resource, String field, long value) {
		super(String.format("%s is not avaiable with %s value:%s", resource,field,value));
		this.resource = resource;
		this.field = field;
		this.value = value;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	
}
