package com.shoppingCart.app.dao;

import com.shoppingCart.app.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingCart.app.model.Order;

import java.util.List;

@Repository
public class OrderDaoImp implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Long save(Order order) {
        return (Long) getSession().save(order);
    }

    @Override
    public List<Order> getAll() {
        String queryString = "FROM Order";
        return sessionFactory.getCurrentSession()
                .createQuery(queryString)
                .list();
    }

    @Override
    public Order findBy(Long idorder) {
        String queryString = "SELECT o FROM Order AS o WHERE o.idorder = :idorder";
        return (Order) getSession().createQuery(queryString)
                .setParameter("idorder", idorder)
                .uniqueResult();
    }
}
