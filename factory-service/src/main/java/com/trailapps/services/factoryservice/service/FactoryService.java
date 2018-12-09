package com.trailapps.services.factoryservice.service;

import com.trailapps.services.factoryservice.client.CustomerClient;
import com.trailapps.services.factoryservice.client.VehiclePartClient;
import com.trailapps.services.factoryservice.model.Customer;
import com.trailapps.services.factoryservice.model.Factory;
import com.trailapps.services.factoryservice.repository.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FactoryService {

    CustomerClient customerClient;
    VehiclePartClient vehiclePartClient;
    private FactoryRepository factoryRepository;

    @Autowired
    public void setFactoryRepository(FactoryRepository factoryRepository) {
        this.factoryRepository = factoryRepository;
    }

    @Autowired
    public void setCustomerClient(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    public List<Factory> findAllParts() {
        Iterable<Factory> iterableParts = factoryRepository.findAll();
        List<Factory> partsList = new ArrayList<>();
        for (Factory part : iterableParts) {
            partsList.add(part);
        }
        return partsList;
    }

    public List<Customer> getCustomerInfo() {
        return customerClient.findAllCustomer();
    }

    public List<Customer> getPartsOfCustomer() {
        List<Customer> customerPartList = vehiclePartClient.getCustomerRequestedPartDetails();
        for (Customer customer : customerPartList) {
            customer.setFactory(factoryRepository.findById(customer.getVehicleParts().getPartCodes()).orElse(null));
        }

        return customerPartList;

    }
}
