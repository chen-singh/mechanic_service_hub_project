package com.service.main.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.service.main.dto.CreateServiceRequest;
import com.service.main.dto.ServiceRequestResponse;
import com.service.main.service.CustomerServiceRequestService;

import java.util.List;

@RestController
@RequestMapping("/api/customer/requests")
public class CustomerServiceRequestController {

    private final CustomerServiceRequestService requestService;

    public CustomerServiceRequestController(
            CustomerServiceRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ServiceRequestResponse createRequest(
            @Valid @RequestBody CreateServiceRequest request) {
        return requestService.createRequest(request);
    }

    @GetMapping
    public List<ServiceRequestResponse> getMyRequests() {
        return requestService.getMyRequests();
    }
}