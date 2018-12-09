package com.trailapps.services.factoryservice.repository;

import com.trailapps.services.factoryservice.model.VehiclePart;
import org.springframework.data.repository.CrudRepository;

public interface VehiclePartRepository extends CrudRepository<VehiclePart, Long> {

    public VehiclePart findByVehicleName(String vehicleName);
}
