package com.vehicles.domain;

import com.vehicles.domain.constants.CarBodyType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name = "id")
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("car")
public class Car extends Vehicle {

    @Enumerated(EnumType.STRING)
    @Column(name = "body_type")
    private CarBodyType bodyType;

}
