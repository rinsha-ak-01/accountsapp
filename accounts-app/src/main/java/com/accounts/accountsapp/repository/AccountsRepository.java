package com.accounts.accountsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounts.accountsapp.model.Accounts;

//import com.accounts.accountsapp.model.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

}
