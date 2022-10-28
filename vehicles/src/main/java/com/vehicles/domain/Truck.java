package com.vehicles.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("truck")
public class Truck extends Vehicle {

    @Column(name = "loading_capacity")
    private String loadingCapacity;

}
