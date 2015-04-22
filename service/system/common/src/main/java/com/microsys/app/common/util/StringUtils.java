package com.microsys.app.common.util;

public class StringUtils extends org.springframework.util.StringUtils {

	public static int getHashCode(String value) {
		
		return (hasLength(value)) ? value.hashCode() : 0;
	}
}
