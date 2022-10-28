package com.vehicles.controller;

import com.vehicles.domain.Vehicle;
import com.vehicles.repository.VehicleRepository;
import com.vehicles.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehiclesController {

    private final VehicleService vehicleService;
    private final VehicleRepository vehicleRepository;

    @GetMapping("/test")
    String test() {
        return "Hello!";
    }

    @PostMapping("/upload/single{filePath}")
    ResponseEntity<List<Vehicle>> uploadDataFromFile(@PathVariable @NotNull String filePath) {
        List<Vehicle> vehicles = this.vehicleService.uploadDataFromFile(filePath);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PostMapping(value = "/upload/bulk", consumes = "application/json")
    ResponseEntity<List<Vehicle>> uploadDataFromFileBulk(@RequestBody @NotNull List<String> filePaths) {
//        return this.vehicleService.uploadDataFromFile(filePath);
        List<Vehicle> vehicles = this.vehicleRepository.findAll();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/vehicles/all")
    ResponseEntity<List<Vehicle>> getAll() {
        List<Vehicle> vehicles = this.vehicleService.findAll();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/vehicles")
    ResponseEntity<Vehicle> getById(@RequestParam @NotNull String uuid) {
        Vehicle vehicle = this.vehicleService.findById(uuid);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }


    @GetMapping("/vehicles/dates")
    ResponseEntity<List<Vehicle>> getByDateRange(@RequestParam @NotNull Integer lower,
                                 @RequestParam @NotNull Integer higher) {
        List<Vehicle> vehicles = this.vehicleRepository.findAll();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/cars/body")
    ResponseEntity<List<Vehicle>> getByBodyType(@RequestBody @NotNull List<String> bodyTypes) {
        List<Vehicle> vehicles = this.vehicleService.findByListOfBodyTypes(bodyTypes);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);    }

    @GetMapping("/cars")
    ResponseEntity<List<Vehicle>> getAllCarsReleasedBeforeDate(@RequestParam @NotNull Integer date) {
        List<Vehicle> vehicles = this.vehicleRepository.findAll();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);    }

    @GetMapping("/trucks")
    ResponseEntity<List<Vehicle>> getAllTrucksReleasedAfterDate(@RequestParam @NotNull Integer date) {
        List<Vehicle> vehicles = this.vehicleRepository.findAll();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);    }

}
