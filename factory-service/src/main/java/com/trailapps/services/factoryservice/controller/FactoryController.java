package com.trailapps.services.factoryservice.controller;

import com.trailapps.services.factoryservice.model.Customer;
import com.trailapps.services.factoryservice.model.Factory;
import com.trailapps.services.factoryservice.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/factory")
public class FactoryController {
    private FactoryService factoryService;

    @Autowired
    public void setFactoryService(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GetMapping("/findAllParts")
    public List<Factory> findAllParts() {

        return factoryService.findAllParts();
    }

    @GetMapping("/findCustomerParts")
    public List<Customer> getCustomerRequestedPartDetails() {
        return factoryService.getPartsOfCustomer();
    }

    @GetMapping("/findAllCustomers")
    public List<Customer> findAllCustomers() {
        return factoryService.getCustomerInfo();
    }
}
