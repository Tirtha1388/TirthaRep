package com.example.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private Boolean status;
	
	public ExceptionResponse(Date timestamp, String message, Boolean status) 
	{
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
	}
	public Date getTimestamp() 
	{
		return timestamp;
	}
	public String getMessage() 
	{
		return message;
	}
	public Boolean getStatus()
	{
		return status;
	}
}
