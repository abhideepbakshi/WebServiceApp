package com.microsys.app.config.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessage {

	final List<String> errorList = new ArrayList<String>();
	
	public void setErrorKey(String key) {

		errorList.add(key);
	}
	
	public List<String> getErrorList() {
		return errorList;
	}
	
}
