package com.trailapps.services.vehicledetailservice.client;

import com.trailapps.services.vehicledetailservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping("/findAllCustomer")
    List<Customer> findAllCustomer();

}