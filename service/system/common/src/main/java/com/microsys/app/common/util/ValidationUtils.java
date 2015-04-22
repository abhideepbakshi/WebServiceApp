package com.microsys.app.common.util;

public final class ValidationUtils {

	private final static String USER_PATTERN = "^[A-Za-z]{3,25}$";
	private final static String PASSWORD_PATTERN = "^[A-Za-z ./@#$%]{3,25}$";
	private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean userName(String userName) {
		if (userName != null) {
			return userName.matches(USER_PATTERN);
		}
		return false;
	}

	public static boolean password(String password) {
		if (password != null) {
			return password.matches(PASSWORD_PATTERN);
		}
		return false;
	}

	public static boolean email(String email) {
		if (email != null) {
			return email.matches(EMAIL_PATTERN);
		}
		return false;
	}

}
