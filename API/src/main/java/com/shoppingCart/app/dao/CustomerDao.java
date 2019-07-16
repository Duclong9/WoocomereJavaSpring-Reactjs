package com.shoppingCart.app.dao;

import com.shoppingCart.app.model.Customer;

import java.util.List;

public interface CustomerDao {

	Customer findBy(String username);
	Long save(Customer customer);
	List<Customer> getAll();
	
}
