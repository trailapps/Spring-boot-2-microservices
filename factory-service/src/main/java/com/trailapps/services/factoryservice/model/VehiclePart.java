package com.trailapps.services.factoryservice.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class VehiclePart {

    private long id;

    @NonNull
    private String vehicleName;

    @NonNull
    private String partCodes;
}
