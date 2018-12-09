package com.trailapps.services.factoryservice.controller;

import com.trailapps.services.factoryservice.model.Customer;
import com.trailapps.services.factoryservice.model.VehiclePart;
import com.trailapps.services.factoryservice.service.VehiclePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiclepart")
public class VehiclePartController {
    private VehiclePartService vehiclePartService;

    @Autowired
    public void setVehiclePartService(VehiclePartService vehiclePartService) {
        this.vehiclePartService = vehiclePartService;
    }

    @GetMapping("/findAllVehicleParts")
    public List<VehiclePart> getAllVehicleParts() {

        return vehiclePartService.getVehicleParts();
    }

    @GetMapping("/findCustomerParts")
    public List<Customer> getCustomerRequestedPartDetails() {
        return vehiclePartService.getAllPartsOfCustomer();
    }
}
