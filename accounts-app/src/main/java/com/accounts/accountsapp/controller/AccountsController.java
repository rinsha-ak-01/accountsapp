package com.accounts.accountsapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.accountsapp.request.AccountsDTO;
import com.accounts.accountsapp.response.AccountsResponse;
import com.accounts.accountsapp.service.AccountsService;

@RestController
@RequestMapping("/api/v1/account/accounts")
public class AccountsController {
	
	@Autowired 
	AccountsService accountsService;
	
	
	 @GetMapping("{id}")
	  public AccountsResponse getAccountDetails(@PathVariable Integer id) {
	    return accountsService.getAnAccountDetail(id);
	  }
	 
	  @PostMapping("/create")
	  public void saveAccountDetails(@RequestBody @Valid AccountsDTO accountsDTO ) {
		  System.out.println("hiiiii");
		  accountsService.save(accountsDTO);
	  }
	  
	  
	  @PutMapping("/update/{id}")
	  public void updateAccount(@PathVariable int id, @RequestBody AccountsDTO accountsDTO) {
		  accountsService.updateAccount(id, accountsDTO);
	  }
	  
	  
	  @GetMapping
	  public Page<AccountsResponse> getAccounts(@PageableDefault(size = 10) Pageable pageable) {
	    return accountsService.getAllAccountDetails(pageable);
	  }
	  
	  @DeleteMapping("/delete/{id}")
	  public void deleteAccount(@PathVariable int id) {
		  accountsService.deleteAccount(id);
	  }


}
