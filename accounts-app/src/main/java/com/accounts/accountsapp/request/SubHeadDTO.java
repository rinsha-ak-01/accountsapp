package com.accounts.accountsapp.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubHeadDTO {
	
	private long id;
	private String item;
	private long parentId;
	private boolean activeStatus;
	private boolean deleteStatus;

}
