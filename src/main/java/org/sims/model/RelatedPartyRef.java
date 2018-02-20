package org.sims.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "relatedpartyrefs")
public class RelatedPartyRef {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String href;

    private String name;

    private String role;

    // TODO make proper object
    private String validFor;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "relatedPartyRefs")
    private Set<Service> services = new HashSet<>();
}
