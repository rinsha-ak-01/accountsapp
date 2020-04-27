package com.accounts.accountsapp.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubHeadResponse {

	private long id;
	private String item;
	private long parentId;
	private boolean activeStatus;
	private boolean deleteStatus;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;	

}
