package org.sims.controller;


import com.fasterxml.jackson.databind.JsonNode;
import org.sims.exception.ResourceNotFoundException;
import org.sims.model.Service;
import org.sims.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Arrays;


@RestController
@CrossOrigin(origins="*")
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
        //ResponseEntity.created(service);
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

    // Update a field of a service
    @PatchMapping("/services/{id}")
    public ResponseEntity<?> partialUpdateService(@RequestBody JsonNode data, @PathVariable("id") Long id) {
        Service s = serviceRepository.getOne(id);
        String path = data.findPath("path").asText().substring(1).toUpperCase();
        String op = data.findPath("op").asText();
        JsonNode value = data.findPath("value");


        Method[] methods = Service.class.getMethods();

        for(Method method : methods) {
            if(method.toString().toUpperCase().contains("SET" + path)) {
                try {
                    Object v = value.asText();
                    System.out.println(v);
                    if(method.getParameterTypes()[0] == Boolean.class){
                        v = value.asBoolean();
                    }
                    method.invoke(s, v);
                } catch(IllegalAccessException e) {
                    System.err.println(e);
                } catch(InvocationTargetException e) {
                    System.err.println(e);
                }
            }
        }
        serviceRepository.save(s);
        return ResponseEntity.ok().build();
    }
}
