package org.sims.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ServiceRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbid;

    private String href;
    private String id;

    @OneToOne(mappedBy = "serviceRef")
    private ServiceRelationship serviceRelationship;

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

    @JsonIgnore
    public ServiceRelationship getServiceRelationship() {
        return serviceRelationship;
    }

    public void setServiceRelationship(ServiceRelationship serviceRelationship) {
        this.serviceRelationship = serviceRelationship;
    }
}
