package com.trailapps.services.vehicledetailservice.controller;

import com.trailapps.services.vehicledetailservice.model.Customer;
import com.trailapps.services.vehicledetailservice.model.VehiclePart;
import com.trailapps.services.vehicledetailservice.service.VehiclePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vehiclepart")
public class VehiclePartController {
    private VehiclePartService vehiclePartService;

    @Autowired
    public void setVehiclePartService(VehiclePartService vehiclePartService) {
        this.vehiclePartService = vehiclePartService;
    }

    public List<VehiclePart> getVehicleParts() {

        return vehiclePartService.getVehicleParts();
    }

    public List<Customer> getCustomerRequestedPartDetails() {
        return vehiclePartService.getAllPartsOfCustomer();
    }
}
