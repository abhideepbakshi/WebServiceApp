package com.microsys.app.common.customenum;

public enum PhoneTypeEnum {

	Mobile("Mobile", "M"), Phone("Phone", "P");

	private String uiCode;
	private String dbCode;

	private PhoneTypeEnum(String uiCode, String dbCode) {

		this.uiCode = uiCode;
		this.dbCode = dbCode;

	}
	
	public String getUiCode() {
		return this.uiCode;
	}

	public String getDbCode() {
		return this.dbCode;
	}
	
	public static PhoneTypeEnum getPhoneTypeByUiCode(String uiCode) {
		final PhoneTypeEnum[] values = PhoneTypeEnum.values();
		for (PhoneTypeEnum status : values) {
			if (status.getUiCode().equals(uiCode)) {
				return status;
			}
		}

		return null;

	}
	
	public static PhoneTypeEnum getPhoneTypeByDBCode(String dbCode) {
		final PhoneTypeEnum[] values = PhoneTypeEnum.values();
		for (PhoneTypeEnum status : values) {
			if (status.getDbCode().equals(dbCode)) {
				return status;
			}
		}

		return null;

	}
	
	public boolean equals(PhoneTypeEnum custComp) {
		return this.dbCode.equals(custComp.getDbCode());
	}
	

}
