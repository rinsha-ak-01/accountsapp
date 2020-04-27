package com.accounts.accountsapp.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeadResponse {
	
	public int id;
	
	public String item;
	
	public boolean activeStatus;
	
	public boolean deleteStatus;
	
	public LocalDateTime createdAt;
	
	public String parentId;	
	
	}
