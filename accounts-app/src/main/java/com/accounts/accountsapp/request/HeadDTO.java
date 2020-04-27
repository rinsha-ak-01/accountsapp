package com.accounts.accountsapp.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeadDTO {

	private int id;

	@NotNull(message = "Headname can't be empty")
	private String item;
	
	private long parentId;
	
	private boolean activeStatus;
	
	
	private boolean deleteStatus;

}
