package com.accounts.accountsapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accounts.accountsapp.request.AccountsDTO;
import com.accounts.accountsapp.response.AccountsResponse;

public interface AccountsService {
	
	public AccountsResponse getAnAccountDetail(Integer id);

	public void save(AccountsDTO accountsDTO);

	public void updateAccount(int id, AccountsDTO accountsDTO);

	public Page<AccountsResponse> getAllAccountDetails(Pageable pageable);

	public void deleteAccount(int id);

}
