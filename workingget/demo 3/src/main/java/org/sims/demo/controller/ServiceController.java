package org.sims.demo.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.sims.demo.model.Service;
import org.sims.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping(
            value = {"/services"},
            produces = {"application/json"}
    )
    public MappingJacksonValue getServices(@RequestParam MultiValueMap<String, String> params) {
        Iterable<Service> services = this.serviceRepository.findAll();
        System.out.println(services);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(services);
        System.out.println("Params = " + params);
        System.out.println("Queries = " + params.keySet());
        Object[] queries = params.keySet().toArray();
        Object[] var5 = queries;
        int var6 = queries.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Object query = var5[var7];
            System.out.println("Query = " + query.toString());
            System.out.println(params.get(query));
        }

        SimpleFilterProvider filters;
        if (params.containsKey("fields")) {
            System.out.println("Entering if");
            filters = (new SimpleFilterProvider()).addFilter("org.sims.demo.model.Service", SimpleBeanPropertyFilter.filterOutAllExcept(((String)params.getFirst("fields")).split(",")));
            mappingJacksonValue.setFilters(filters);
            System.out.println((String)params.getFirst("fields"));
            return mappingJacksonValue;
        } else {
            filters = (new SimpleFilterProvider()).addFilter("org.sims.demo.model.Service", SimpleBeanPropertyFilter.serializeAll());
            mappingJacksonValue.setFilters(filters);
            return mappingJacksonValue;
        }
    }
}
