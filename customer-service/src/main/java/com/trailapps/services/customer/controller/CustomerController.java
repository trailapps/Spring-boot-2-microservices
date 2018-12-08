package com.trailapps.services.customer.controller;

import com.trailapps.services.customer.model.Customer;
import com.trailapps.services.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> findAllCustomer() {
        return customerService.findAllCustomers();
    }
}
