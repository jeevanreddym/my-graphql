package com.my.graphql.learn.mygraphql.gql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.my.graphql.learn.mygraphql.model.vehicle.Vehicle;
import com.my.graphql.learn.mygraphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMutation implements GraphQLMutationResolver {
    private VehicleService vehicleService;

    @Autowired
    public VehicleMutation(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }
}
