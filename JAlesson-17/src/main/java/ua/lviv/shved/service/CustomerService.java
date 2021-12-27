package ua.lviv.shved.service;

import java.util.Date;
import java.util.List;

import ua.lviv.shved.domain.Customer;

public interface CustomerService{
	
	Customer save(Customer customer);

	Customer findById(Long id);

	Customer update(Customer customer);

	void deleteById(Long id);

	List<Customer> findAll();

	List<Customer> findByEmail(String email);

	List<Customer> findByDate(Date date);
}
