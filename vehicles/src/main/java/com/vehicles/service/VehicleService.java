package com.vehicles.service;

import com.vehicles.domain.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> uploadDataFromFile(String filePath);
//    void createVehicle(VehicleRequestDto vehicleRequestDto);

    List<Vehicle> findAll();

    Vehicle findById(String uuid);

    List<Vehicle> findByListOfBodyTypes(List<String> bodyTypes);
}
