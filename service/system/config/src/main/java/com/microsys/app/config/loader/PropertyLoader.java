package com.microsys.app.config.loader;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.microsys.app.config.CacheConfig;
import com.microsys.app.config.filetype.Provider;
import com.microsys.app.config.util.ConfigException;

public class PropertyLoader<FT , RQ , RS , F extends Provider<FT, RQ, RS>> implements Loader<Provider<FT, RQ, RS>, RQ, RS> {

	private final CacheConfig INSTANCE = CacheConfig.getInstance();

	@SuppressWarnings("unchecked")
	public RS getProperty(RQ propertyName, String filename) throws ConfigException {

		final BaseLoader cache = INSTANCE.getCache(filename);
		if (cache != null) {
			final Provider<Object, Object, Object> provider = cache.getProvider();
			return (RS) provider.getProperty(propertyName);
		}
		
		final Provider<FT, RQ, RS> load = (Provider<FT, RQ, RS>) loadProperty(filename);
		final RS propertyValue = load.getProperty(propertyName);
		final BaseLoader baseLoader = new BaseLoader();
		baseLoader.setProvider((Provider<Object, Object, Object>)load);
		INSTANCE.setData(filename, baseLoader);
		return propertyValue;

	}

	private Provider<FT, RQ, RS> loadProperty(String filename) throws ConfigException {

		final InputStream find = INSTANCE.getFile(filename);
		final Class<F> loadClass = getProvider();
		try {
			Provider<FT, RQ, RS> provider = (Provider<FT, RQ, RS>) loadClass.newInstance();
			provider.initialize(find);
			return provider;
		} catch (InstantiationException e) {
			throw new ConfigException(e.getCause());
		} catch (IllegalAccessException e) {
			throw new ConfigException(e.getCause());
		}

	}

	@SuppressWarnings("unchecked")
	private Class<F> getProvider() {
		final ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		final Type[] actualTypeArguments = type.getActualTypeArguments();
		return (Class<F>) actualTypeArguments[3];
	}

}
