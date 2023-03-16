package com.my.graphql.learn.mygraphql.gql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.my.graphql.learn.mygraphql.model.vehicle.Vehicle;
import com.my.graphql.learn.mygraphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class VehicleQuery implements GraphQLQueryResolver {
    private VehicleService vehicleService;

    @Autowired
    public VehicleQuery(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }

    public Vehicle getVehicle(final UUID id) {
        return this.vehicleService.getVehicle(id);
    }
}
