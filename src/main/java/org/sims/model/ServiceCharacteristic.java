package org.sims.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "servicecharacteristics")
public class ServiceCharacteristic {
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String value;

    // Relations
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "serviceCharacteristic")
    private Set<Service> service = new HashSet<>();
}
