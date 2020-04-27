package com.accounts.accountsapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accounts.accountsapp.request.SubHeadDTO;
import com.accounts.accountsapp.response.SubHeadResponse;

public interface SubHeadService {
		
	public SubHeadResponse getSubHeadDetails(int id);

	public void save(SubHeadDTO subHeadDTO);

	public void updateSubHead(int id, SubHeadDTO subHeadDTO);

	public Page<SubHeadResponse> getAllSubHeadDetails(Pageable pageable);

	public void deleteSubHead(int id);

}
