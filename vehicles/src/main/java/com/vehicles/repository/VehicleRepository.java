package com.vehicles.repository;

import com.vehicles.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

    @Query(value = "SELECT v.discriminator, v.id, v.color, v.fabrication_date, v.type, v.body_type  " +
            "FROM vehicle v " +
            "WHERE v.body_type IN (:bodyTypes)",
            nativeQuery = true)
    List<Vehicle> findCarsByListOfBodyTypes(List<String> bodyTypes);

    @Query(value = "SELECT * FROM vehicle v " +
            "WHERE v.fabrication_date >= :from " +
            "AND  v.fabrication_date < :to",
            nativeQuery = true)
    List<Vehicle> findByDateRange(Date from, Date to);

    @Query(value = "SELECT v.discriminator, v.id, v.color, v.fabrication_date, v.type, v.body_type  " +
            "FROM vehicle v " +
            "WHERE v.fabrication_date < :upper",
            nativeQuery = true)
    List<Vehicle> findCarsReleasedBeforeDate(Date upper);

    @Query(value = "SELECT v.discriminator, v.id, v.color, v.fabrication_date, v.type, v.loading_capacity  " +
            "FROM vehicle v " +
            "WHERE v.fabrication_date > :lower " +
            "AND v.discriminator = 'truck'",
            nativeQuery = true)
    List<Vehicle> findTrucksReleasedAfterDate(Date lower);
}
