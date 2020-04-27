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
import com.accounts.accountsapp.request.SubHeadDTO;
import com.accounts.accountsapp.response.SubHeadResponse;
import com.accounts.accountsapp.service.SubHeadService;

@Service
public class SubHeadServiceImpl implements SubHeadService {

	@Autowired
	HeadRepository headRepository;

	@Override
	public void save(SubHeadDTO subHeadDTO) {
		Head head = new Head();
		try {
			BeanUtils.copyProperties(head, subHeadDTO);
			headRepository.save(head);
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("Invalid data");
		}
	}

	@Override
	public void updateSubHead(int id, SubHeadDTO subHeadDTO) {
		Head head = new Head();
		try {
			BeanUtils.copyProperties(subHeadDTO, head);
			headRepository.save(head);
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("Invalid data");
		}

	}

	@Override
	public Page<SubHeadResponse> getAllSubHeadDetails(Pageable pageable) {
		Page<Head> page = headRepository.findAllSubheads(pageable);
		List<Head> heads = page.getContent();
		List<SubHeadResponse> subHeadResponses = new ArrayList<>();
		for (Head head : heads) {
			SubHeadResponse headResponse = new SubHeadResponse();
			try {
				BeanUtils.copyProperties(headResponse, head);
				subHeadResponses.add(headResponse);
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new com.accounts.accountsapp.exception.BadRequestException("Invalid Data");
			}
		}
		return new PageImpl<>(subHeadResponses, pageable, page.getTotalPages());

	}

	@Override
	public void deleteSubHead(int id) {
		Head head = getHeadData(id);
		headRepository.delete(head);
	}

	@Override
	public SubHeadResponse getSubHeadDetails(int id) {
		Head head = getHeadData(id);
		SubHeadResponse subHeadResponse = new SubHeadResponse();
		try {
			BeanUtils.copyProperties(subHeadResponse, head);
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("Invalid data");
		}
		return subHeadResponse;
	}

	private Head getSubHeadData(int parentId) {
		return headRepository.findByParentId(parentId);
		}
	
	private Head getHeadData(Integer id) {
		return headRepository.findById(id)
				.orElseThrow(() -> new com.accounts.accountsapp.exception.NotFoundException("INnvalid id"));
	}


}
