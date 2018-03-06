package org.sims.controller;


import org.sims.model.Place;
import org.sims.model.Service;
import org.sims.repository.PlaceRepository;
import org.sims.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
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

    // Get a single Service
    @GetMapping("/services/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable(value = "id") Long serviceId) {

        Service service = serviceRepository.findOne(serviceId);

        if(service == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(service);
    }

    // Delete a service
    @DeleteMapping("/services/{id}")
    public ResponseEntity<?> deleteService(@PathVariable(value = "id") Long serviceId) {
        Service service = serviceRepository.findById(serviceId)

                .orElseThrow(() -> new ResourceNotFoundException("Service", "id", serviceId));

        serviceRepository.delete(service);

        return ResponseEntity.ok().build();
    }



}
