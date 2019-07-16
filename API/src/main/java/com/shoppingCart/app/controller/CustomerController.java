package com.shoppingCart.app.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.shoppingCart.app.exception.ProductNotFoundException;
import com.shoppingCart.app.model.MessageResponse;
import com.shoppingCart.app.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingCart.app.exception.AuthenticationFailedException;
import com.shoppingCart.app.model.Customer;
import com.shoppingCart.app.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Customer> login(@RequestBody Map map)
            throws NoSuchAlgorithmException, AuthenticationFailedException {
        MessageResponse mess = new MessageResponse();
        Customer customer = customerService.authentication(map.get("username").toString(), map.get("password").toString());
        if (customer != null) {
            mess.setCode("LOGIN");
            mess.setData(customer);
            mess.setStatus("SUCCESS");
            mess.setMessage("Đăng nhập thành công");
        }
        return new ResponseEntity(mess, HttpStatus.OK);
    }

    @RequestMapping(value = "customer/getAllUser", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Customer>> getCustomer() throws ProductNotFoundException {
        MessageResponse mess = new MessageResponse();
        List<Customer> customers = customerService.getAll();
        mess.setCode(Constants.CODE);
        mess.setData(customers);
        mess.setStatus(Constants.STATUS_ERROR);
        mess.setMessage("Lấy tất cả người dùng thàng công");
        return new ResponseEntity(mess, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Void> addCustomer(@RequestBody Customer customer, HttpServletRequest request)
            throws URISyntaxException, NoSuchAlgorithmException {
        Long id = customerService.addCustomer(customer);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(new URI(request.getRequestURL() + "/" + id.toString()));
        return new ResponseEntity<Void>(header, HttpStatus.CREATED);
    }

}
