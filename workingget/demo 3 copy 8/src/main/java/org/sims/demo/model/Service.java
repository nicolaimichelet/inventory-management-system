package org.sims.demo.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashMap;

@Entity
@JsonFilter("org.sims.demo.model.Service")
@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
public class Service implements Serializable {
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

    @OneToOne(fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    private ServiceSpecification serviceSpecification;

    public Service() {
    }

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

    public void setServiceSpecification(LinkedHashMap lhm) {
        System.out.println("\nasd\nasd\nasd\nasd\nasd\nasd\nasd\nasd\nasd\nasd\nasd\nasd\nasd\nasd");
        System.out.println(lhm);
        System.out.println(lhm.keySet());
        System.out.println(lhm);
        System.out.println();
        System.out.println();

    }


}
