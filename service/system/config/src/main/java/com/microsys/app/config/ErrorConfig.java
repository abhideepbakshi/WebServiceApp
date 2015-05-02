package com.microsys.app.config;

import com.microsys.app.config.error.ApplicationError;
import com.microsys.app.config.error.ErrorEnum;
import com.microsys.app.config.error.ErrorMessage;
import com.microsys.app.config.filetype.ErrorJaxbSerializer;
import com.microsys.app.config.loader.PropertyLoader;
import com.microsys.app.config.util.ConfigException;

public class ErrorConfig extends PropertyLoader<ApplicationError, ErrorEnum, ErrorMessage, ErrorJaxbSerializer> {

	private final static String LOGGER_CONFIG = "error/log-configuration.xml";
	
	public ErrorMessage getProperty(ErrorEnum property) throws ConfigException {

		return getProperty(property, LOGGER_CONFIG);

	}
	
}
