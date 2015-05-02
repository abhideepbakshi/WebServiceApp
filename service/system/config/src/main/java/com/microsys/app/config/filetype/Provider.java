package com.microsys.app.config.filetype;

import java.io.InputStream;

import com.microsys.app.config.util.ConfigException;

public interface Provider<F, RQ, RS> {

	public F initialize(InputStream file) throws ConfigException;
	
	public RS getProperty(RQ propertyName) throws ConfigException;
}

