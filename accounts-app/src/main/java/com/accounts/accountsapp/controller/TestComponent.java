package com.accounts.accountsapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
public class TestComponent {
	public void test() {
		System.err.println("----------------------------------------------------");
	}

}
