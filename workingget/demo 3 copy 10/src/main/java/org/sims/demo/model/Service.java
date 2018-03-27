package org.sims.demo.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.sims.demo.controller.ServiceController;
import org.sims.demo.repository.ServiceRepository;
import org.sims.demo.repository.ServiceSpecificationRepository;
import org.sims.demo.repository.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
@JsonFilter("org.sims.demo.model.Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbid;

    private String name;
    private String href;
    private String category;
    private Boolean isStateful;

/*
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;
*/
//
//    private final ServiceRepository serviceRepository;
//    private final ServiceSpecificationRepository serviceSpecificationRepository;
//    @Autowired
//    public Service(ServiceRepository serviceRepository, ServiceSpecificationRepository serviceSpecificationRepository) {
//        this.serviceRepository = serviceRepository;
//        this.serviceSpecificationRepository = serviceSpecificationRepository;
//    }



    @OneToOne(fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    private ServiceSpecification serviceSpecification;

    public Long getId() {
        return this.dbid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIsStateful() {
        return isStateful;
    }

    public void setIsStateful(Boolean isStateful) {
        this.isStateful = isStateful;
    }

    public ServiceSpecification getServiceSpecification() {
        return serviceSpecification;
    }

    public void setServiceSpecification(ServiceSpecification serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
    }


    /*
    //TODO be able to create new objects through PATCH
    //Updates current object
    public void setServiceSpecification(LinkedHashMap lhm) {
        this.serviceSpecification.setVersion("asd");
        this.serviceSpecification.setName("asdasd");
        this.serviceSpecification.setId("asddsa");
        this.serviceSpecification.setHref("asdsadadd");
        System.out.println("\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nasd\nasd");
        System.out.println(lhm);
        System.out.println(lhm.keySet());
        System.out.println(lhm);
        System.out.println();
        System.out.println();
    }
    */



    @Autowired
    ServiceController serviceController;

    //This shouldn't work. This has to be illegal 🌮👌
    public void customSetServiceSpecification(LinkedHashMap lhm) {
        ServiceSpecification serviceSpecification = new ServiceSpecification();
        serviceSpecification.setVersion("asd");
        serviceSpecification.setName("asdasd");
        serviceSpecification.setId("asddsa");
        serviceSpecification.setHref("asdsadadd");
        this.setServiceSpecification(serviceSpecification);
        serviceController.createService(this);
        System.out.println("\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nCreate new entry\nasd\nasd");
        System.out.println(lhm);
        System.out.println(lhm.keySet());
        System.out.println(lhm);
        System.out.println();
        System.out.println();
//        serviceTest.setServiceSpecification(serviceSpecification);
    }



    //TODO be able to update id of object
    public void customSetServiceSpecification(Integer id) {
        String lewl = id.toString();
        Long lul = new Long(lewl);
        this.serviceSpecification.setDbid(lul);
        System.out.println("\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID");
    }

}
