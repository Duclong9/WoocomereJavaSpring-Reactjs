package com.shoppingCart.app.service;

import com.shoppingCart.app.dao.OrderDao;
import com.shoppingCart.app.exception.OrderNotFoundException;
import com.shoppingCart.app.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;



@Service
@Transactional
public class OrderServiceImp implements OrderSevice {

    @Autowired
    OrderDao orderDao;

    @Override
    public Order findBy(Long idorder) throws OrderNotFoundException {
        Order orders = orderDao.findBy(idorder);
        if (orders != null) {
            return orders;
        } else
            throw new OrderNotFoundException();
    }

    @Override
    public List<Order> getAll() throws OrderNotFoundException {
        List<Order> orders = orderDao.getAll();
        if (orders.isEmpty() || orders == null)
            throw new OrderNotFoundException();
        else
            return orders;

    }

    @Override
    public Long addOrder(Order order) throws NoSuchAlgorithmException {
        return orderDao.save(order);
    }
}
