package org.sims.model;

import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "services")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Service implements Serializable {
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotBlank
    private String category;

    @NotBlank
    private String description;

    // Relations
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "service")
    private Set<ServiceOrder> serviceOrder = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", nullable = true)
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bundle_id", nullable = true)
    private Bundle bundle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicecharacteristic_id", nullable = true)
    private ServiceCharacteristic serviceCharacteristic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "note_id", nullable = true)
    private Note note;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "service")
    private ServiceSpecificationRef serviceSpecificationRef;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "service_relatedpartyrefs",
            joinColumns = { @JoinColumn(name = "service_id") },
            inverseJoinColumns = { @JoinColumn(name = "relatedpartyref_id") })
    private Set<RelatedPartyRef> relatedPartyRefs = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "service_supportingresources",
            joinColumns = { @JoinColumn(name = "service_id") },
            inverseJoinColumns = { @JoinColumn(name = "supportingresource_id") })
    private Set<SupportingResource> supportingResources = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "service_supportingservices",
            joinColumns = { @JoinColumn(name = "service_id") },
            inverseJoinColumns = { @JoinColumn(name = "supportingservice_id") })
    private Set<SupportingService> supportingServices = new HashSet<>();



    public Service() {

    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}


