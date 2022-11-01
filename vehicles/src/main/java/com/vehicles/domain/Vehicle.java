package com.vehicles.domain;

import com.vehicles.domain.constants.VehicleType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminator",
        discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    protected UUID uuid;

    @Enumerated(EnumType.STRING)
    @Column
    protected VehicleType type;

    @Column(name = "color")
    protected String color;

    @Column(name = "fabrication_date")
    protected LocalDate fabricationDate;

}
