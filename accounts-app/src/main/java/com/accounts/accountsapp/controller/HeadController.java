/**
 * 
 */
package com.accounts.accountsapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.accountsapp.request.HeadDTO;
import com.accounts.accountsapp.response.HeadResponse;
import com.accounts.accountsapp.service.HeadService;


@RestController
@RequestMapping("/api/v1/account/head")
public class HeadController {
	
	 @Autowired
	 private HeadService headService;
		
	 
	  @GetMapping("{id}")
	  public HeadResponse getHeadDetails(@PathVariable Integer id) {
		 return headService.getHeadDetails(id);
	      
	  }
	 
	  @PostMapping("/create")
	  @ResponseStatus(code = HttpStatus.CREATED)
	  public void saveHeadDetails(@RequestBody @Valid HeadDTO headDto ) {
		  headService.save(headDto);
	  }
	  
	  
	  @PutMapping("/update/{id}")
	  public void updateHead(@PathVariable int id, @RequestBody HeadDTO headDto) {
		  headService.updateHead(id, headDto);
	  }
	  
	  
	  @GetMapping
	  public Page<HeadResponse> getAccounts(@PageableDefault(size = 10) Pageable pageable) {
	    return headService.getAllHeadDetails(pageable);
	  }
	  
	  @DeleteMapping("/delete/{id}")
	  public void deleteHead(@PathVariable int id) {
		  headService.deleteHead(id);
	  }


}
