package com.my.graphql.learn.mygraphql.repository;


import com.my.graphql.learn.mygraphql.model.vehicle.Vehicle;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class VehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> findAll() {
        return vehicles;
    }

    public Vehicle findById(UUID vehicleId) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getId() == vehicleId)
                .findFirst().orElseThrow(() -> new RuntimeException("Vehicle not found!"));
    }

    public Vehicle save(Vehicle vehicle) {

        return null;
    }

    @PostConstruct
    private void init() {
        vehicles.addAll(List.of(
                Vehicle.builder()
                        .id(UUID.randomUUID())
                        .brandName("Jungle Vehicle")
                        .build(),
                Vehicle.builder()
                        .id(UUID.randomUUID())
                        .brandName("Spy Kid")
                        .build()
        ));
    }
}
