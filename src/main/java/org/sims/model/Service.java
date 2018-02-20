package org.sims.model;

import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.sims.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    private String category;

    private String description;

    // TODO make date object
    private String endDate;

    // TODO make boolean
    private String hasStarted;

    private String href;

    // TODO make booleans
    private String isServiceEnabled;
    private String isStateful;

    @NotNull
    private String name;

    // TODO make date objects
    private String orderDate;
    private String startDate;

    private String startMode;

    private String state;

    private String type;

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

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setHasStarted(String hasStarted) {
        this.hasStarted = hasStarted;
    }

    public String getHasStarted() {
        return hasStarted;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setIsServiceEnabled(String isServiceEnabled) {
        this.isServiceEnabled = isServiceEnabled;
    }

    public String getIsServiceEnabled() {
        return isServiceEnabled;
    }

    public void setIsStateful(String isStateful) {
        this.isStateful = isStateful;
    }

    public String getIsStateful() {
        return isStateful;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartMode(String startMode) {
        this.startMode = startMode;
    }

    public String getStartMode() {
        return startMode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Transient
    public void setPlace(Place place) {
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }
}


