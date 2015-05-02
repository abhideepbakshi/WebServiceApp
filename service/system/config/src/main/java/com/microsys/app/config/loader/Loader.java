package com.microsys.app.config.loader;

import com.microsys.app.config.util.ConfigException;

public interface Loader<FT, RQ, RS> {

	RS getProperty(RQ propertyName, String filename) throws ConfigException;

}
