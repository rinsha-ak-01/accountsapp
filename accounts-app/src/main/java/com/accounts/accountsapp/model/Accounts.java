package com.accounts.accountsapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "accounts")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "club_id")
	private Long clubId;

	@Column(name = "head_id")
	private Long headId;

	@Column(name = "subhead_id")
	private Long subheadId;

	@Column(name = "type")
	private String type;

	@Column(name = "amount")
	private double amount;

	@Column(name = "bill_no")
	private String billNo;

	@Column(name = "invoice_no")
	private String invoiceNo;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "transaction_type")
	private String transactionType;

	@CreationTimestamp
	@Column(name = "inserted_on")
	private Date insertedOn;

	@UpdateTimestamp
	@Column(name = "updated_on")
	private Date upadatedOn;
	
	@Column(name = "check_no")
	private String checkNo;
	
	@Column(name = "ifsc_code")
	private String ifscCode;
		
	@Column(name = "check_issued_date")
	private Date checkIssuedDate;
	
	@Column(name = "upi_id")
	private String upiId;
	
	@Column(name = "transferred_date")
	private Date trasferredDate;


}
