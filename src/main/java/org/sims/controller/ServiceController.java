package org.sims.controller;


import org.sims.exception.ResourceNotFoundException;
import org.sims.model.Service;
import org.sims.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;


    @GetMapping("/services")
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @PostMapping("/services")
    public Service createService(@Valid @RequestBody Service service) {
        return serviceRepository.save(service);
    }

    // Get a Single Service
    @GetMapping("/notes/{id}")
    public Service getServiceById(@PathVariable(value = "id") Long serviceId) {
        return serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", serviceId));
    }



}
