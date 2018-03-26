package org.sims.demo.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.querydsl.core.types.Predicate;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.sims.demo.model.Service;
import org.sims.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Optional;



@RestController
@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
public class ServiceController {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    //Get all services. If "fields" is present, only the fields specified will be returned.
    @GetMapping("/service")
    @ResponseBody
    public MappingJacksonValue getServices(@RequestParam MultiValueMap<String,
            String> params, @QuerydslPredicate(root = Service.class) Predicate predicate) {

        Iterable<Service> services = this.serviceRepository.findAll(predicate);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(services);
        return applyFieldFiltering(mappingJacksonValue, params);
    }

    //Method to return only the specified fields
    private MappingJacksonValue applyFieldFiltering(MappingJacksonValue mappingJacksonValue, MultiValueMap<String,
            String> params) {
        SimpleFilterProvider filters;

        if (params.containsKey("fields")) {
            filters = (new SimpleFilterProvider()).addFilter("org.sims.demo.model.Service",
                    SimpleBeanPropertyFilter.filterOutAllExcept(((String)params.getFirst("fields")).split(",")));
            mappingJacksonValue.setFilters(filters);
            return mappingJacksonValue;

        } else {
            filters = (new SimpleFilterProvider()).addFilter("org.sims.demo.model.Service", SimpleBeanPropertyFilter.serializeAll());
            mappingJacksonValue.setFilters(filters);
            return mappingJacksonValue;
        }
    }


    //TODO Apply filtering, for some reason
    //TODO Return proper message back when resource isn't found (if(user==null))
    //Returns the service resource of the given id
    @GetMapping("/service/{id}")
    @ResponseBody
    public MappingJacksonValue getService(@PathVariable Long id, @RequestParam MultiValueMap<String,
            String> params, @QuerydslPredicate(root = Service.class) Predicate predicate) {

        Optional<Service> service = this.serviceRepository.findById(id);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(service);
        return applyFieldFiltering(mappingJacksonValue, params);

    }


    //TODO currently working, but need to find a better way to return the created object
    //Creates a service in the database from the service JSON passed. Returns the created object.
    @PostMapping("/service")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public MappingJacksonValue createService(@Valid @RequestBody Service service) {
        SimpleFilterProvider filters;
        filters = (new SimpleFilterProvider()).addFilter("org.sims.demo.model.Service",
                SimpleBeanPropertyFilter.serializeAll());
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(serviceRepository.save(service));
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;

    }

    //TODO Proper exception handling for invalid id
    //Deletes the service at the given id
    @DeleteMapping("/service/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteService(@PathVariable Long id) {
        serviceRepository.deleteById(id);
    }

    //TODO Exception handling for invalid id
    //TODO Be able to create subresources
    //TODO add check for update or delete
    //Partially updates a service according to the TMForum API
    @PatchMapping("/service/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public MappingJacksonValue patchService(@PathVariable("id") Long id, @Valid @RequestBody PatchObject patchObject) {
        Optional<Service> s = this.serviceRepository.findById(id);
        if(!s.isPresent()) {
            //TODO add proper exception handling and http status code
            return null;
        }
        Service service = s.get();
//        try {
//            PropertyUtils.setProperty(service, patchObject.getPath(), patchObject.getValue());
//        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
//            e.printStackTrace();
//        }

        //Method method = MethodUtils.getAccessibleMethod(service.getClass(), "setServiceSpecification", Object.class);
        try {
            MethodUtils.invokeExactMethod(service, "set" + patchObject.getPath(), patchObject.getValue());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        serviceRepository.save(service);
        SimpleFilterProvider filters;
        filters = (new SimpleFilterProvider()).addFilter("org.sims.demo.model.Service",
                SimpleBeanPropertyFilter.serializeAll());
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(service);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

}
