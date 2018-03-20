package org.sims.model;

import org.hibernate.annotations.Cascade;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;


@Entity(name = "Service")
@Table(name = "service", indexes = {
    @Index(columnList = "uuid", name = "unique_id")
})
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
//        allowGetters = true)
@Transactional
public class Service implements Serializable {
  // Columns
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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


  //TODO fikse cascading
  // Relations

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "serviceorder_id")
  private ServiceOrder serviceOrder;

  @OneToMany(
      mappedBy = "service",
      cascade = CascadeType.ALL
  )
  private Set<Place> places = new HashSet<>();


  @OneToMany(
      mappedBy = "service",
      cascade = CascadeType.ALL
  )
  private Set<Note> notes = new HashSet<>();


  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private ServiceSpecificationRef serviceSpecificationRef;

  @ManyToMany(fetch = FetchType.EAGER,
      cascade = CascadeType.ALL)
  @JoinTable(name = "service_servicerelationship",
      joinColumns = { @JoinColumn(name = "service_id") },
      inverseJoinColumns = { @JoinColumn(name = "servicerelationship_id") })
  private Set<ServiceRelationship> serviceRelationship = new HashSet<>();


  @ManyToMany(fetch = FetchType.EAGER,
      cascade = CascadeType.MERGE)
  @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
  @JoinTable(name = "service_servicecharacteristic",
      joinColumns = { @JoinColumn(name = "service_id") },
      inverseJoinColumns = { @JoinColumn(name = "servicecharacteristic_id") })
  private Set<ServiceCharacteristic> serviceCharacteristic = new HashSet<>();


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

  private static Method[] methods;

  public static Method[] getMethods() {
    return methods;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
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

  public void setPlace(Set<Place> places) {
    for(Place place : places) {
      this.places.add(place);
      place.setService(this);
    }
  }


  public Set<Place> getPlace() {
    return places;
  }

  public void setNote(Set<Note> notes) {
    for(Note note : notes) {
      this.notes.add(note);
      note.setService(this);
    }
  }

  public Set<Note> getNote() {
    return notes;
  }

  public void setRelatedPartyRefs(Set<RelatedPartyRef> relatedPartyRefs) {
    this.relatedPartyRefs = relatedPartyRefs;
  }

  public Set<RelatedPartyRef> getRelatedPartyRefs() {
    return relatedPartyRefs;
  }

  public void setServiceCharacteristic(Set<ServiceCharacteristic> serviceCharacteristic) {
    this.serviceCharacteristic = serviceCharacteristic;
  }

  public Set<ServiceCharacteristic> getServiceCharacteristic() {
    return serviceCharacteristic;
  }

  public void setServiceOrder(ServiceOrder serviceOrder) {
    this.serviceOrder = serviceOrder;
  }

  public ServiceOrder getServiceOrder() {
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

  public Set<ServiceRelationship> getServiceRelationship() {
    return serviceRelationship;
  }


}
