package com.microsys.app.model.entity.customtype;

import java.lang.reflect.ParameterizedType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public abstract class BaseUserType<T> implements UserType {

	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == y) {//NOSONAR
			return true;
		} else if (x == null || y == null) {
			return false;
		} else {
			return x.equals(y);
		}

	}

	public int hashCode(Object arg0) throws HibernateException {
		return arg0 != null? arg0.hashCode() : this.hashCode()+100;
	}

	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	public boolean isMutable() {
		return false;
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	@Override
	public Class<?> returnedClass() {
		final ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<?>) type.getActualTypeArguments()[0];

	}

	@Override
	public Object nullSafeGet(ResultSet resulSet, String[] names, SessionImplementor arg2, Object owner) throws HibernateException, SQLException {
		return get(resulSet, owner, names);
	}

	@Override
	public void nullSafeSet(PreparedStatement statement, Object value, int index, SessionImplementor arg3) throws HibernateException, SQLException {
		set(statement, (T) value, index);
	}

	public abstract void set(PreparedStatement statement, T value, int index) throws SQLException;

	public abstract T get(ResultSet resulSet, Object owner, String[] names) throws SQLException;
}
