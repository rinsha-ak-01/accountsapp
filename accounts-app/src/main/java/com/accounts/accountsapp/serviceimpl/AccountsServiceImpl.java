package com.accounts.accountsapp.serviceimpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.accounts.accountsapp.model.Accounts;
import com.accounts.accountsapp.repository.AccountsRepository;
import com.accounts.accountsapp.request.AccountsDTO;
import com.accounts.accountsapp.response.AccountsResponse;
import com.accounts.accountsapp.service.AccountsService;

@Service
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	AccountsRepository accountRepository;

	@Override
	public AccountsResponse getAnAccountDetail(Integer id) {
		Accounts accounts = getAccountsData(id);
		AccountsResponse accountsResponse = new AccountsResponse();
		try {
			BeanUtils.copyProperties(accountsResponse, accounts);
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("Invalid data");
		}
		return accountsResponse;
	}

	@Override
	public void save(AccountsDTO accountsDTO) {
		Accounts account = new Accounts();
		try {
			BeanUtils.copyProperties(account, accountsDTO);
			accountRepository.save(account);
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("Invalid data");
		}
	}

	@Override
	public void updateAccount(int id, AccountsDTO accountsDTO) {
		Accounts accounts = getAccountsData(id);
		try {
			BeanUtils.copyProperties(accounts, accountsDTO);
			accountRepository.save(accounts);
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("Invalid data");
		}
	}

	@Override
	public Page<AccountsResponse> getAllAccountDetails(Pageable pageable) {
		Page<Accounts> page = accountRepository.findAll(pageable);
		List<Accounts> accounts = page.getContent();
		List<AccountsResponse> accountsResponses = new ArrayList<>();

		for (Accounts account : accounts) {
			AccountsResponse accountResponse = new AccountsResponse();
			try {
				BeanUtils.copyProperties(accountResponse, account);
				accountsResponses.add(accountResponse);
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new com.accounts.accountsapp.exception.BadRequestException("Invalid Data");
			}
		}
		return new PageImpl<>(accountsResponses, pageable, page.getTotalPages());
	}

	@Override
	public void deleteAccount(int id) {
		Accounts accounts = getAccountsData(id);
		accountRepository.delete(accounts);
	}

	private Accounts getAccountsData(int id) {
		return accountRepository.findById(id)
				.orElseThrow(() -> new com.accounts.accountsapp.exception.NotFoundException("Invalid id"));
	}

}
