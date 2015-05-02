package com.microsys.app.config.error;

public enum ErrorEnum {

	LoginPasswordError(10001),
	LoginUsernameError(10002),
	LoginError(10003);
	
	private int errorCode;

	private ErrorEnum(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}
}
