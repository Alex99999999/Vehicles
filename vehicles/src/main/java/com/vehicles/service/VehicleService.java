package com.vehicles.service;

import com.vehicles.domain.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> uploadDataFromFile(String filePath);

    List<Vehicle> findAll();

    Vehicle findById(String uuid);

    List<Vehicle> findByListOfBodyTypes(List<String> bodyTypes);

    List<Vehicle> findByDateRange(String lower, String higher);

    List<Vehicle> findCarsReleasedBeforeDate(String date);

    List<Vehicle> findTrucksReleasedAfterDate(String date);

}
