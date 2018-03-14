package org.sims.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "servicespecificationrefs")
public class ServiceSpecificationRef {
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String href;

    private String name;

    private String version;

    // Relations
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = true)
    private Service service;
}
