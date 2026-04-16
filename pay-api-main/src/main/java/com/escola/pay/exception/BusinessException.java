package com.escola.pay.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 5314732080193531754L;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
