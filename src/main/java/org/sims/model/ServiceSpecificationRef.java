package org.sims.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ServiceSpecification")
@Table(name = "servicespecification")
public class ServiceSpecificationRef {

    // Columns
    @Id
    @GeneratedValue
    private Long id;

    private String href;

    private String name;

    private String version;

    // Relations
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;

    public ServiceSpecificationRef() {

    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}
