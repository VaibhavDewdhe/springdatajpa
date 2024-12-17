package com.dev.exception;

public class InvalidArgument extends Exception {
	public InvalidArgument() {};
	public InvalidArgument(String message) {
		super(message);
	}
}
