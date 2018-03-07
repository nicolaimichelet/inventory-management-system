package org.sims.controller;


import org.sims.exception.ResourceNotFoundException;
import org.sims.model.Service;
import org.sims.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sims.PatchService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;

    // Get all services
    @GetMapping("/services")
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    // Create a new service
    @PostMapping("/services")
    public Service createService(@Valid @RequestBody Service service) {
        return serviceRepository.save(service);
    }

    // Get a Single Service
    @GetMapping("/services/{id}")
    public Service getServiceById(@PathVariable(value = "id") Long serviceId) {
        return serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Service", "id", serviceId));
    }

    // Delete a Service
    @DeleteMapping("/services/{id}")
    public ResponseEntity<?> deleteService(@PathVariable(value = "id") Long serviceId) {
        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Service", "id", serviceId));

        serviceRepository.delete(service);
        return ResponseEntity.ok().build();
    }


    // TODO
    /*
    @PatchMapping("/services/{id}")
    public ResponseEntity<?> partialUpdateService(@RequestBody Service service, @PathVariable("id") Long id) {

        Service s = serviceRepository.getOne(id);
        s.setName(service.getName());
        s.setCategory(service.getCategory());
        serviceRepository.save(s);
        return ResponseEntity.ok().build();

    }*/

    @PatchMapping("/services/{id}")
    public ResponseEntity<?> partialUpdateService(@RequestBody PatchService patchService, @PathVariable("id") Long id) {
        Service s = serviceRepository.getOne(id);
        String path = patchService.path.substring(1);
        String value = patchService.value;
        String op = patchService.op;

        System.out.println(path);
        System.out.println(value);
        System.out.println(op);



        serviceRepository.save(s);
        return ResponseEntity.ok().build();

    }



}
