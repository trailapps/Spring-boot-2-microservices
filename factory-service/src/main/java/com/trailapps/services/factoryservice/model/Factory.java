package com.trailapps.services.factoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factory")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Factory {

    @Id
    private String partCode;

    private String partName;

    private long availability;

    private boolean hasWarranty;

}
