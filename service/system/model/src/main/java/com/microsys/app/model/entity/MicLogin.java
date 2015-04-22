package com.microsys.app.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.microsys.app.common.audit.BaseAuditEntity;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.model.dao.framework.IIdentityObject;
import com.microsys.app.model.entity.customtype.RecordStatusType;

@Entity
@Table(name = "mic_login")
@NamedQuery(name = "MicLogin.findAll", query = "SELECT m FROM MicLogin m")
public class MicLogin extends BaseAuditEntity implements IIdentityObject<Long>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LOGIN_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long loginId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Type(type = RecordStatusType.USER_TYPE)
	@Column(name = "STATUS")
	private RecordStatusEnum status;

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RecordStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
	}

	@Override
	public Long get() {
		return loginId;
	}
	
	
	
	
}
