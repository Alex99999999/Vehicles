package com.vehicles.repository;

import com.vehicles.domain.Vehicle;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

    @Query(value = "SELECT v.discriminator, v.id, v.color, v.fabrication_date, v.type, v.body_type  " +
            "FROM vehicle v " +
            "WHERE v.body_type IN (:bodyTypes)",
            nativeQuery = true)
    List<Vehicle> findByListOfBodyTypes(List<String> bodyTypes);

}
