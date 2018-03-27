package org.sims.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RelatedParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbid;

    private String href;
    private String id;
    private String name;
    private String role;
    private String validFor;

    /*
    @ManyToMany(mappedBy="courses")
	private List<Student> students = new ArrayList<>();
     */

    @ManyToMany(mappedBy = "relatedParties")
    private List<Service> services = new ArrayList<>();

    public Long getDbid() {
        return dbid;
    }

    public void setDbid(Long dbid) {
        this.dbid = dbid;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getValidFor() {
        return validFor;
    }

    public void setValidFor(String validFor) {
        this.validFor = validFor;
    }

    @JsonIgnore
    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
