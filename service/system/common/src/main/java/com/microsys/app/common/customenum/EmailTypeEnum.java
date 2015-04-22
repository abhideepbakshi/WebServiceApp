package com.microsys.app.common.customenum;

public enum EmailTypeEnum {

	Email("Email","E"),
	Web("Web","W");
	
	private String uiCode;
	private String dbCode;

	private EmailTypeEnum(String uiCode, String dbCode) {

		this.uiCode = uiCode;
		this.dbCode = dbCode;

	}
	
	public String getUiCode() {
		return this.uiCode;
	}

	public String getDbCode() {
		return this.dbCode;
	}
	
	public static EmailTypeEnum getEmailTypeByUiCode(String uiCode) {
		final EmailTypeEnum[] values = EmailTypeEnum.values();
		for (EmailTypeEnum status : values) {
			if (status.getUiCode().equals(uiCode)) {
				return status;
			}
		}

		return null;

	}
	
	public static EmailTypeEnum getEmailTypeByDBCode(String dbCode) {
		final EmailTypeEnum[] values = EmailTypeEnum.values();
		for (EmailTypeEnum status : values) {
			if (status.getDbCode().equals(dbCode)) {
				return status;
			}
		}

		return null;

	}
	
	public boolean equals(EmailTypeEnum custComp) {
		return this.dbCode.equals(custComp.getDbCode());
	}
}
