package com.microsys.app.config.loader;

import com.microsys.app.config.filetype.Provider;

public class BaseLoader {

	private Provider<Object, Object, Object> provider;

	public Provider<Object, Object, Object> getProvider() {
		return provider;
	}

	public void setProvider(Provider<Object, Object, Object> provider) {
		this.provider = provider;
	}

}
