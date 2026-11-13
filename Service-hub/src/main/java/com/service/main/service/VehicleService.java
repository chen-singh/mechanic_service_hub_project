

package com.service.main.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.service.main.dto.VehicleRequest;
import com.service.main.dto.VehicleResponse;
import com.service.main.entity.Users;
import com.service.main.entity.Vehicle;
import com.service.main.repository.UserRepository;
import com.service.main.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public VehicleService(
            VehicleRepository vehicleRepository,
            UserRepository userRepository) {

        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    private Users getLoggedInCustomer() {

        String email = SecurityContextHolder.getContext()
                .getAuthentication().getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));
    }

    // Add Vehicle
    public VehicleResponse addVehicle(VehicleRequest request) {

        Users customer = getLoggedInCustomer();

        Vehicle vehicle = new Vehicle();

        vehicle.setCustomer(customer);
        vehicle.setBrand(request.make());
        vehicle.setModel(request.model());
        vehicle.setManufacturingYear(request.year());
        vehicle.setRegistrationNumber(
                request.registrationNumber());

        Vehicle saved = vehicleRepository.save(vehicle);

        return toResponse(saved);
    }

    // Get My Vehicles
    public List<VehicleResponse> getMyVehicles() {

        Users customer = getLoggedInCustomer();

        return vehicleRepository
                .findByCustomerId(customer.getId())
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // Delete Vehicle
    public void deleteVehicle(Long id) {

        Users customer = getLoggedInCustomer();

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Vehicle not found"));

        if (!vehicle.getCustomer().getId()
                .equals(customer.getId())) {

            throw new RuntimeException(
                    "You cannot delete another customer's vehicle");
        }

        vehicleRepository.delete(vehicle);
    }

    // Convert Entity to DTO
    private VehicleResponse toResponse(Vehicle vehicle) {

        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingYear(),
                vehicle.getRegistrationNumber()
        );
    }
}
