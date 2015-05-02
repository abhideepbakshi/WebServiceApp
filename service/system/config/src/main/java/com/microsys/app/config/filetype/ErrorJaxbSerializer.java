package com.microsys.app.config.filetype;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.microsys.app.config.error.ApplicationError;
import com.microsys.app.config.error.Error;
import com.microsys.app.config.error.ErrorEnum;
import com.microsys.app.config.error.ErrorMessage;
import com.microsys.app.config.error.ErrorType;
import com.microsys.app.config.error.Service;
import com.microsys.app.config.util.ConfigException;

public class ErrorJaxbSerializer implements
		ErrorProvider<ApplicationError, ErrorEnum, ErrorMessage> {

	private ApplicationError applicationError = new ApplicationError();
	private static final Map<Integer, ErrorMessage> errorCache = new ConcurrentHashMap<Integer, ErrorMessage>();

	@Override
	public ApplicationError initialize(InputStream file) throws ConfigException {
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(ApplicationError.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			applicationError = (ApplicationError) jaxbUnmarshaller
					.unmarshal(file);
		} catch (JAXBException e) {
			throw new ConfigException("Unable to read jaxb file", e.getCause());
		}
		return null;
	}

	@Override
	public ErrorMessage getProperty(ErrorEnum property) throws ConfigException {
		return readService(property);
	}

	@Override
	public ErrorMessage getErrorDetails(ErrorEnum errorName) {

		//errorCache.get(key);
		
		final ErrorMessage errorMsg = readService(errorName);
		if (errorMsg != null) {
			errorCache.put(errorMsg.getErrorNum(), errorMsg);
		}
		return errorMsg;
	}

	private ErrorMessage readService(ErrorEnum errorName) {
		final ErrorMessage errorMsg = new ErrorMessage();
		for (Service service : applicationError.getService()) {

			for (ErrorType errorType : service.getErrorType()) {
				for (Error error : errorType.getError()) {
					if (error.getErrorNum() == errorName.getErrorCode()) {
						errorMsg.setDescription(error.getDescription());
						errorMsg.setErrorCode(error.getErrorCode());
						errorMsg.setErrorNum(error.getErrorNum());
						errorMsg.setErrorType(errorType.getName());
						errorMsg.setServiceName(service.getName());
						return errorMsg;
					}
				}
			}
		}
		return null;
	}

}
