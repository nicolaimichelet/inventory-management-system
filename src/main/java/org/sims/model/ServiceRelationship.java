package org.sims.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "servicerelationship")
public class ServiceRelationship {
    public ServiceRelationship() {

    }

    public ServiceRelationship(ServiceRef serviceRef) {
        this.serviceRef = serviceRef;
    }

    //Columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    // Relations
    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "serviceRelationship")
    private Set<Service> services = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceref_id", nullable = true)
    private ServiceRef serviceRef;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setServiceRef(ServiceRef serviceRef) {
        this.serviceRef = serviceRef;
    }

    public ServiceRef getServiceRef() {
        return serviceRef;
    }
}
