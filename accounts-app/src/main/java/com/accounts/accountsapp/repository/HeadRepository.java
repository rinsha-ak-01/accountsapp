package com.accounts.accountsapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accounts.accountsapp.model.Head;

public interface HeadRepository extends JpaRepository<Head, Integer> {

	@Query(value = "SELECT * FROM head WHERE parent_id = ?1", nativeQuery = true)
	Head findByParentId(int parentId);
	
	@Query(value = "SELECT * FROM head WHERE parent_id IS NOT NULL AND parent_id !=0 ", nativeQuery = true)
	Page<Head> findAllSubheads(Pageable pageable);

}
