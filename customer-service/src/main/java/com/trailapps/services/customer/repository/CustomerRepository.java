package com.trailapps.services.customer.repository;


import com.trailapps.services.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CustomerRepository extends MongoRepository<Customer, UUID> {
}
