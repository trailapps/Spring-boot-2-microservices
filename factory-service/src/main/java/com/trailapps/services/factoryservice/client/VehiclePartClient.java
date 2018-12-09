package com.trailapps.services.factoryservice.client;

import com.trailapps.services.factoryservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "vehicle-part-service")
public interface VehiclePartClient {

    @GetMapping("/vehiclepart/findCustomerParts")
    List<Customer> getCustomerRequestedPartDetails();

}