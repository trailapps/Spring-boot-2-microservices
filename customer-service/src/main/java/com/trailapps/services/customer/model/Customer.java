package com.trailapps.services.customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document
public class Customer {

    @Id
    private UUID id;

    private String name;

    private String address;

    private String selectedCarModal;

    private Date orderedDate;
}
