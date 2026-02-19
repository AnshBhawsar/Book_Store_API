package com.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Repository.customerREpository;
import com.model.Customer;
@Transactional
@Service
public class CustomerService {
private customerREpository repo;
public CustomerService(customerREpository repo) {
	this.repo=repo;
}
public int addCustomer(Customer c) {
	return repo.addCustomer(c);
}
public Customer getById(int id) {
	if(id<=0) {
		throw new IllegalArgumentException("invalid id");
	}
	return repo.getById(id);
}
}
