package com.service.main.dto;




public record VehicleResponse(
    Long id,
    String make,
    String model,
    Integer year,
    String registrationNumber
) {
}
//public record VehicleResponse(
//        Long id,
//        String make,
//        String model,
//        Integer year,
//        String registrationNumber
//) {
//
//	}
