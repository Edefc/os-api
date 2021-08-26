package com.edenilson.osapi.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataIntegratyViolationException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public DataIntegratyViolationException(String msg) {
		super(msg);
	}

}
