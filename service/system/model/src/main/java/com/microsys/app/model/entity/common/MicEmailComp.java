package com.microsys.app.model.entity.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import com.microsys.app.common.audit.BaseAuditEntity;
import com.microsys.app.common.customenum.CustCompEnum;
import com.microsys.app.common.customenum.EmailTypeEnum;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.common.util.StringUtils;
import com.microsys.app.model.entity.MicCompany;
import com.microsys.app.model.entity.customtype.CustCompType;
import com.microsys.app.model.entity.customtype.EmailType;
import com.microsys.app.model.entity.customtype.RecordStatusType;

/**
 * The persistent class for the mic_email database table.
 * 
 */
@Entity
@Table(name = "mic_email")
@NamedQuery(name = "MicEmailComp.findAll", query = "SELECT m FROM MicEmailComp m")
public class MicEmailComp extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMAIL_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long emailId;

	@Column(name = "EMAIL_DETL")
	private String emailDetl;

	@Column(name = "EMAIL_TYPE")
	@Type(type = EmailType.EMAIL_TYPE)
	private EmailTypeEnum emailType;

	@Column(name = "TYPE")
	@Type(type = CustCompType.CUST_COMP)
	@Where(clause = "type = 'COMP'")
	private CustCompEnum type;

	@Column(name = "STATUS")
	@Type(type = RecordStatusType.USER_TYPE)
	private RecordStatusEnum status;

	@ManyToOne
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "COMP_ID")
	private MicCompany company;

	public Long getEmailId() {
		return this.emailId;
	}

	public void setEmailId(Long emailId) {
		this.emailId = emailId;
	}

	public String getEmailDetl() {
		return this.emailDetl;
	}

	public void setEmailDetl(String emailDetl) {
		this.emailDetl = emailDetl;
	}

	public EmailTypeEnum getEmailType() {
		return this.emailType;
	}

	public void setEmailType(EmailTypeEnum emailType) {
		this.emailType = emailType;
	}

	public CustCompEnum getType() {
		return this.type;
	}

	public void setType(CustCompEnum type) {
		this.type = type;
	}

	public boolean equals(MicEmailComp email) {
		return this.emailId == email.getEmailId() ? true : false;
	}

	public RecordStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
	}

	public MicCompany getCompany() {
		return company;
	}

	public void setCompany(MicCompany company) {
		this.company = company;
	}
	
	@Override
	public int hashCode() {
		return StringUtils.getHashCode(emailDetl) + StringUtils.getHashCode(type.getDbCode());
	}

}