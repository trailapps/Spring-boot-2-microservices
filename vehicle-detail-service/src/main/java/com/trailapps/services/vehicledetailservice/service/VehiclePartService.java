package com.trailapps.services.vehicledetailservice.service;

import com.trailapps.services.vehicledetailservice.client.CustomerClient;
import com.trailapps.services.vehicledetailservice.model.Customer;
import com.trailapps.services.vehicledetailservice.model.VehiclePart;
import com.trailapps.services.vehicledetailservice.repository.VehiclePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiclePartService {

    CustomerClient customerClient;
    private VehiclePartRepository vehiclePartRepository;

    @Autowired
    public void setVehiclePartRepository(VehiclePartRepository vehiclePartRepository) {
        this.vehiclePartRepository = vehiclePartRepository;
    }

    @Autowired
    public void setCustomerClient(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    public List<VehiclePart> getVehicleParts() {
        Iterable<VehiclePart> iterableVehicleParts = vehiclePartRepository.findAll();
        List<VehiclePart> vehicleParts = new ArrayList<>();
        for (VehiclePart vehiclePart : iterableVehicleParts) {
            vehicleParts.add(vehiclePart);
        }
        return vehicleParts;
    }

    public List<Customer> getAllPartsOfCustomer() {
        List<Customer> customerList = customerClient.findAllCustomer();
        for (Customer customer : customerList) {
            customer.setVehicleParts(vehiclePartRepository.findByVehicleName(customer.getSelectedCarModal()));
        }

        return customerList;

    }
}
