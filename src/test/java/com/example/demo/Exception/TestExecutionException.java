package com.example.demo.Exception;

public class TestExecutionException extends RuntimeException{
	public TestExecutionException(String message, Throwable cause) {
		super(message, cause);
	}
}
