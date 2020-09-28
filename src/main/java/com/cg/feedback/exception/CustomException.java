package com.cg.feedback.exception;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException{
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
	public CustomException(String message) {
		super(message);
	}
	public CustomException(Throwable cause) {
		super(cause);
	}

}
