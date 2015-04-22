package com.microsys.app.config;

import org.junit.Test;

import com.microsys.app.config.util.ConfigException;

public class LogConfigTest {

	@Test
	public void loadLogger(){
		LogConfig config = new LogConfig();
		
		try {
			String rootLoglevel = config.getProperty("log.config.level.root");
		} catch (ConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
