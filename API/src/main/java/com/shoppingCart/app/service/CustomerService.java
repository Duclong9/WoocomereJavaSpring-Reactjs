package com.shoppingCart.app.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.shoppingCart.app.exception.AuthenticationFailedException;
import com.shoppingCart.app.exception.ProductNotFoundException;
import com.shoppingCart.app.model.Customer;

public interface CustomerService {

    Customer authentication(String username, String password)
            throws NoSuchAlgorithmException, AuthenticationFailedException;
    Long addCustomer(Customer customer) throws NoSuchAlgorithmException;
    List<Customer> getAll();
}
