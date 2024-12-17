package com.dev.exception;

public class NotFoundException extends RuntimeException{
	public NotFoundException() {}
	
	public NotFoundException(String message) {
		super(message);
	}
	
	public String toString() {
		return "DataNotFoundException";
	}
}
