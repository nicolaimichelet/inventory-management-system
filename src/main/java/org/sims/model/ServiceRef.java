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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String href;

    // Relations
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicerelationship_id", nullable = true)
    private ServiceRelationship serviceRelationship;
}
