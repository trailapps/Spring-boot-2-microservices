package com.trailapps.services.factoryservice.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Customer {

    private UUID id;

    private String name;

    private String address;

    private String selectedCarModal;

    private Date orderedDate;

    private VehiclePart vehicleParts;

    private Factory factory;

}
