package com.customerData.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.customerData.model.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
	
	List<Customer> findByName(String name);
	
	Customer findByNameAndId(String name,long id);
	
	List<Customer> findByNameLike(String pattern,Pageable pageable);
	
	List<Customer> findByIdBetween(long to, long form);
	
	
	
	
}
