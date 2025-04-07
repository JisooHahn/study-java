package com.app.exception.post;

public class PostNotFoundException extends RuntimeException{
	public PostNotFoundException() {;}
	
	public PostNotFoundException(String message) {
		super(message);
	}
}
