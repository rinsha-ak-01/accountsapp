/**
 * 
 */
package com.accounts.accountsapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accounts.accountsapp.request.HeadDTO;
import com.accounts.accountsapp.response.HeadResponse;

/**
 * @author Rinsha
 *
 */

public interface HeadService {
	
	public HeadResponse getHeadDetails(Integer id);
	
	public void save(HeadDTO headDTO);
	
	public void updateHead(int id, HeadDTO headDTO);
	
	public Page<HeadResponse> getAllHeadDetails(Pageable pageable);
	
	public void deleteHead(int id);

}
