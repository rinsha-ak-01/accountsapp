package com.accounts.accountsapp.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountsResponse {

	private long id;
	private long clubId;
	private long headId;
	private long subheadId;
	private String type;
	private double amount;
	private String billNo;
	private String invoiceNo;
	private String remarks;
	private String transactionType;
	private String checkNo;
	private String ifscCode;
	private Date checkIssuedDate;
	private String upiId;
	private Date trasferredDate;

}
