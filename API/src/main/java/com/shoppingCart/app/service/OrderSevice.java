package com.shoppingCart.app.service;

import com.shoppingCart.app.exception.OrderNotFoundException;
import com.shoppingCart.app.model.Order;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface OrderSevice {
    Order findBy(Long idorder) throws OrderNotFoundException;

    List<Order> getAll() throws OrderNotFoundException;

    Long addOrder(Order order) throws NoSuchAlgorithmException;
}
