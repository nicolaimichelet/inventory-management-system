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
@Table(name = "services", indexes = {
        @Index(columnList = "uuid", name = "unique_id")
})
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Service implements Serializable {
    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String uuid;

    private String category;

    private String description;

    private Date endDate;

    private Boolean hasStarted;

    private String href;

    private Boolean isServiceEnabled;
    private Boolean isStateful;

    @NotNull
    private String name;

    private Date orderDate;
    private Date startDate;

    private String startMode;

    private String state;

    private String type;

    // Relations
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "service")
    private Set<ServiceOrder> serviceOrder = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id", nullable = true)
    private Place place;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "bundle_id", nullable = true)
    private Bundle bundle;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "servicecharacteristic_id", nullable = true)
    private ServiceCharacteristic serviceCharacteristic;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "note_id", nullable = true)
    private Note note;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "service")
    private ServiceSpecificationRef serviceSpecificationRef;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "service_relatedpartyrefs",
            joinColumns = { @JoinColumn(name = "service_id") },
            inverseJoinColumns = { @JoinColumn(name = "relatedpartyref_id") })
    private Set<RelatedPartyRef> relatedPartyRefs = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "service_supportingresources",
            joinColumns = { @JoinColumn(name = "service_id") },
            inverseJoinColumns = { @JoinColumn(name = "supportingresource_id") })
    private Set<SupportingResource> supportingResources = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,
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

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
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

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setHasStarted(Boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    public Boolean getHasStarted() {
        return hasStarted;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setIsServiceEnabled(Boolean isServiceEnabled) {
        this.isServiceEnabled = isServiceEnabled;
    }

    public Boolean getIsServiceEnabled() {
        return isServiceEnabled;
    }

    public void setIsStateful(Boolean isStateful) {
        this.isStateful = isStateful;
    }

    public Boolean getIsStateful() {
        return isStateful;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
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

    public void setPlace(Place place) {
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Note getNote() {
        return note;
    }

    public void setRelatedPartyRefs(Set<RelatedPartyRef> relatedPartyRefs) {
        this.relatedPartyRefs = relatedPartyRefs;
    }

    public Set<RelatedPartyRef> getRelatedPartyRefs() {
        return relatedPartyRefs;
    }

    public void setServiceCharacteristic(ServiceCharacteristic serviceCharacteristic) {
        this.serviceCharacteristic = serviceCharacteristic;
    }

    public ServiceCharacteristic getServiceCharacteristic() {
        return serviceCharacteristic;
    }

    public void setServiceOrder(Set<ServiceOrder> serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public Set<ServiceOrder> getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceSpecificationRef(ServiceSpecificationRef serviceSpecificationRef) {
        this.serviceSpecificationRef = serviceSpecificationRef;
    }

    public ServiceSpecificationRef getServiceSpecificationRef() {
        return serviceSpecificationRef;
    }

    public void setSupportingResources(Set<SupportingResource> supportingResources) {
        this.supportingResources = supportingResources;
    }

    public Set<SupportingResource> getSupportingResources() {
        return supportingResources;
    }

    public void setSupportingServices(Set<SupportingService> supportingServices) {
        this.supportingServices = supportingServices;
    }

    public Set<SupportingService> getSupportingServices() {
        return supportingServices;
    }
}
