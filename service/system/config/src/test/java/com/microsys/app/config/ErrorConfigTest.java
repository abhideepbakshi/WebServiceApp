package com.microsys.app.config;

import org.junit.Test;

import com.microsys.app.config.error.ErrorEnum;
import com.microsys.app.config.error.ErrorMessage;
import com.microsys.app.config.util.ConfigException;

public class ErrorConfigTest {

	@Test
	public void findErrorMsg(){
		
		ErrorConfig errorConfig = new ErrorConfig();
		try {
			final ErrorMessage errorMsg = errorConfig.getProperty(ErrorEnum.LoginError);
			System.out.println(errorMsg.getDescription());
		} catch (ConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
