package com.trailapps.services.factoryservice.client;

import com.trailapps.services.factoryservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping("/customer/findAllCustomer")
    List<Customer> findAllCustomer();

}