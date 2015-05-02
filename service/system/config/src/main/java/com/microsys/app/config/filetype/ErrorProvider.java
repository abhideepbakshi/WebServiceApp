package com.microsys.app.config.filetype;

/**
 * 
 * @author Hitman
 *
 * @param <F> is the type the jaxb file contain
 * @param <RT> request the code type
 * @param <RS> response type
 */
public interface ErrorProvider<F, RQ, RS> extends Provider<F, RQ, RS>{

	RS getErrorDetails(RQ errorName);
}
