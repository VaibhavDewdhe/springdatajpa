package com.dev.exception;

import java.time.LocalDateTime;

public class MyErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String Description;
	public MyErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyErrorDetails(LocalDateTime timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		Description = description;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "MyErrorDetails [timestamp=" + timestamp + ", message=" + message + ", Description=" + Description + "]";
	}
	
}
