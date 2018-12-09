package com.trailapps.services.factoryservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_part")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class VehiclePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String vehicleName;

    @NonNull
    private String partCodes;
}
