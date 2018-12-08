package com.trailapps.services.vehicledetailservice.repository;

import com.trailapps.services.vehicledetailservice.model.VehiclePart;
import org.springframework.data.repository.CrudRepository;

public interface VehiclePartRepository extends CrudRepository<VehiclePart, Long> {

    public VehiclePart findByVehicleName(String vehicleName);
}
