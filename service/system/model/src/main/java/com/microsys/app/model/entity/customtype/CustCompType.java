package com.microsys.app.model.entity.customtype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;

import com.microsys.app.common.customenum.CustCompEnum;

public class CustCompType extends BaseUserType<CustCompEnum>{

	public static final String CUST_COMP = "com.microsys.app.model.entity.customtype.CustCompType";

	@Override
	public Object assemble(Serializable arg0, Object arg1) throws HibernateException {
		return arg0;
	}

	@Override
	public Serializable disassemble(Object arg0) throws HibernateException {
		return (Serializable) arg0;
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}

	@Override
	public void set(PreparedStatement statement, CustCompEnum value, int index) throws SQLException {
		if (value == null) {
			statement.setNull(index, Types.VARCHAR);
		} else {
			final CustCompEnum status = ((CustCompEnum) value);
			statement.setString(index, status.getDbCode());
		}
		
	}

	@Override
	public CustCompEnum get(ResultSet resulSet, Object owner, String[] names) throws SQLException {
		if (names != null && names.length == 1) {
			final String codeColumn = names[0];
			final String string = resulSet.getString(codeColumn);
			if (string != null && string.length() >0) {
				return CustCompEnum.getCustCompByDBCode(string);
			}
			else {
				return null;
			}
		}
		return null;
	}
	
	

}
