package com.shoppingCart.app.dao;

import com.shoppingCart.app.model.Order;

import java.util.List;

public interface OrderDao {

	Long save(Order order);
	List<Order> getAll();
	Order findBy(Long idorder);

}

