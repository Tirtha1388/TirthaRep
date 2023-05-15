package com.example.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InputErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InputErrorException(String message) 
	{
		super(message);
	}
}
