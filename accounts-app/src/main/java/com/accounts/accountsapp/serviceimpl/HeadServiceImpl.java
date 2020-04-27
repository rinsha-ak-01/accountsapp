/**
 * 
 */
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

import com.accounts.accountsapp.model.Head;
import com.accounts.accountsapp.repository.HeadRepository;
import com.accounts.accountsapp.request.HeadDTO;
import com.accounts.accountsapp.response.HeadResponse;
import com.accounts.accountsapp.service.HeadService;

/**
 * @author Rinsha
 *
 */
@Service
public class HeadServiceImpl implements HeadService {

	@Autowired
	HeadRepository headRepository;

	@Override
	public HeadResponse getHeadDetails(Integer id) {
		Head head = getHeadData(id);
		HeadResponse headResponse = new HeadResponse();
		try {
			BeanUtils.copyProperties(headResponse, head);
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("Invalid data");
		}
		return headResponse;
	}

	@Override
	public void save(HeadDTO headDTO) {
		Head head = new Head();
		try {
			BeanUtils.copyProperties(head, headDTO);
			headRepository.save(head);
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("Invalid data");
		}
	}

	@Override
	public void updateHead(int id, HeadDTO headDTO) {
		Head head = getHeadData(id);
		try {
			BeanUtils.copyProperties(head, headDTO);
			headRepository.save(head);
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("Invalid data");
		}

	}

	@Override
	public Page<HeadResponse> getAllHeadDetails(Pageable pageable) {
		Page<Head> page = headRepository.findAll(pageable);
		List<Head> heads = page.getContent();
		List<HeadResponse> headResponses = new ArrayList<>();

		for (Head head : heads) {
			HeadResponse headResponse = new HeadResponse();
			try {
				BeanUtils.copyProperties(headResponse, head);
				headResponses.add(headResponse);
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new com.accounts.accountsapp.exception.BadRequestException("Invalid Data");
			}
		}
		return new PageImpl<>(headResponses, pageable, page.getTotalPages());
	}

	@Override
	public void deleteHead(int id) {
		Head head = getHeadData(id);
		headRepository.delete(head);

	}

	private Head getHeadData(Integer id) {
		return headRepository.findById(id)
				.orElseThrow(() -> new com.accounts.accountsapp.exception.NotFoundException("INnvalid id"));
	}

}
