package org.sims.demo.repository;

import org.sims.demo.model.ServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Optional;

@RestController
@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
public class EntityHelper {
    @Autowired
    ServiceSpecificationRepository serviceSpecificationRepository;

    @Transactional
    public ServiceSpecification findById(Long id) {
        System.out.println("ServiceSpecificationRepository = " + serviceSpecificationRepository);
        System.out.println("Entered EntityHelper");
        Optional<ServiceSpecification> s = serviceSpecificationRepository.findById(id);
        System.out.println("Found by id in EntityHelper");
        ServiceSpecification ser = s.get();
        System.out.println("Found ServiceSpecification in EntityHelper");
        return ser;
    }
}
