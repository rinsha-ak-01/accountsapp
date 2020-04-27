package com.accounts.accountsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableAutoConfiguration 
@SpringBootApplication
@EnableSwagger2
public class AccountsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsAppApplication.class, args);
	}
	
//	@Bean
//	   public Docket productApi() {
//	      return new Docket(DocumentationType.SWAGGER_2).select()
//	         .apis(RequestHandlerSelectors.basePackage("com.accounts.accountsapp")).build();
//	   }

}
