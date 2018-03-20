package org.sims.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "serviceref")
public class ServiceRef {
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String href;

    // Relations
    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "serviceRef")
    private ServiceRelationship serviceRelationship;

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }
}
