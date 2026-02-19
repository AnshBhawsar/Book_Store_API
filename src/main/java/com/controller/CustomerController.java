package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.CustomerService;
import com.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
 private CustomerService cs;
 @Autowired
 public CustomerController( CustomerService cs) {
	 this.cs=cs;
 }
 @PostMapping("/add")
 public String addCustomer( @RequestBody Customer c) {
	 cs.addCustomer(c);
	 return "Customer added successfully";
 }
 @GetMapping("/{id}")
 public Customer getById(@PathVariable int id) {
	 return cs.getById(id);
 }
 
}
