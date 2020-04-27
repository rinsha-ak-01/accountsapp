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

import com.accounts.accountsapp.request.SubHeadDTO;
import com.accounts.accountsapp.response.SubHeadResponse;
import com.accounts.accountsapp.service.SubHeadService;

@RestController
@RequestMapping("/api/v1/account/subhead")
public class SubHeadController {

	@Autowired
	SubHeadService subheadService;
	
	
	 @GetMapping("{id}")
	  public SubHeadResponse getSubheadDetails(@PathVariable int id) {
	    return subheadService.getSubHeadDetails(id);
	  }
	 
	  @PostMapping("/create")
	  public void saveSubHeadDetails(@RequestBody @Valid SubHeadDTO subHeadDTO ) {
		  subheadService.save(subHeadDTO);
	  }
	  
	  
	  @PutMapping("/update/{id}")
	  public void updateSubheadt(@PathVariable int id, @RequestBody SubHeadDTO subHeadDTO) {
		  subheadService.updateSubHead(id, subHeadDTO);
	  }
	  
	  
	  @GetMapping
	  public Page<SubHeadResponse> getSubheadDetails(@PageableDefault(size = 10) Pageable pageable) {
	    return subheadService.getAllSubHeadDetails(pageable);
	  }
	  
	  @DeleteMapping("/delete/{id}")
	  public void deleteSubhead(@PathVariable int id) {
		  subheadService.deleteSubHead(id);
	  }
}
