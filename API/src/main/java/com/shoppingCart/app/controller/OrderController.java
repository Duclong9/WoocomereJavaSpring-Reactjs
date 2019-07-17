package com.shoppingCart.app.controller;

import com.shoppingCart.app.exception.OrderNotFoundException;
import com.shoppingCart.app.model.MessageResponse;
import com.shoppingCart.app.model.Order;
import com.shoppingCart.app.service.OrderSevice;
import com.shoppingCart.app.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderSevice orderSevice;

    @RequestMapping(value = "order/getAllOrder", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Order>> getOrder() throws OrderNotFoundException {
        MessageResponse mess = new MessageResponse();
        List<Order> orders = orderSevice.getAll();
        mess.setCode(Constants.CODE);
        mess.setData(orders);
        mess.setStatus(Constants.STATUS_SUCCESS);
        mess.setMessage("Lấy tất cả hóa đơn thàng công");
        return new ResponseEntity(orders, HttpStatus.FOUND);
    }
}
