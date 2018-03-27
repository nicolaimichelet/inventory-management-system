package org.sims.demo.repository;

import org.sims.demo.model.ServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Configuration
public class ServiceTest {
    @Autowired
    ServiceSpecificationRepository serviceSpecificationRepository;

    @Transactional
    public void setServiceSpecification(ServiceSpecification serviceSpecification) {
        System.out.println("Entered ServiceTest with argument = " + serviceSpecification.toString());
        serviceSpecificationRepository.save(serviceSpecification);
    }

}
