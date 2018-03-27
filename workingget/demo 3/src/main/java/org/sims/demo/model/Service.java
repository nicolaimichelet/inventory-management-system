package org.sims.demo.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.sims.demo.controller.ServiceController;
import org.sims.demo.repository.EntityHelper;
import org.sims.demo.repository.ServiceRepository;
import org.sims.demo.repository.ServiceSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.*;

@Entity
@JsonFilter("org.sims.demo.model.Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbid;

    private String name;
    private String href;
    private String category;
    private Boolean isStateful;

    //-------------Relations-----------------
    //-------------OneToOne------------------

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ServiceSpecification serviceSpecification;



    //--------------OneToMany------------------

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Place> places = new HashSet<>();

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Note> notes = new HashSet<>();

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<ServiceCharacteristic> serviceCharacteristics = new HashSet<>();

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<ServiceRelationship> serviceRelationships = new HashSet<>();


    //---------------ManyToOne----------------

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ServiceOrder serviceOrder;



    //---------------ManyToMany---------------

    @ManyToMany
    @JoinTable(name = "SERVICE_RELATED_PARTY",
            joinColumns = @JoinColumn(name = "SERVICE_DBID"),
            inverseJoinColumns = @JoinColumn(name = "RELATED_PARTY_DBID"))
    private List<RelatedParty> relatedParties = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "SERVICE_SUPPORTING_RESOURCE",
            joinColumns = @JoinColumn(name = "SERVICE_DBID"),
            inverseJoinColumns = @JoinColumn(name = "SUPPORTING_RESOURCE_DBID"))
    private List<SupportingResource> supportingResources = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "SERVICE_SUPPORTING_SERVICE",
            joinColumns = @JoinColumn(name = "SERVICE_DBID"),
            inverseJoinColumns = @JoinColumn(name = "SUPPORTING_SERVICE_DBID"))
    private List<SupportingService> supportingServices = new ArrayList<>();


    //------------Constructor-----------------
    public Service() {
    }

    public Long getId() {
        return this.dbid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIsStateful() {
        return isStateful;
    }

    public void setIsStateful(Boolean isStateful) {
        this.isStateful = isStateful;
    }

    public ServiceSpecification getServiceSpecification() {
        return serviceSpecification;
    }

    public void setServiceSpecification(ServiceSpecification serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
    }

    //TODO update currently replaces the existing servicespecification with the given parameters, even if they're not present
    //Creates or updates service specification depending on the value of op
    public void customSetServiceSpecification(LinkedHashMap lhm, String op) {
        if(op.equals("update")) {
            System.out.println("\nUPDATING EXISTING SERVICESPECIFICATION \n");
            //TODO Add a check to see which attributes are passed before applying.
            this.serviceSpecification.setVersion((String)lhm.get("version"));
            this.serviceSpecification.setName((String)lhm.get("name"));
            this.serviceSpecification.setId((String)lhm.get("id"));
            this.serviceSpecification.setHref((String)lhm.get("href"));
        }
        else if(op.equals("replace")) {
            System.out.println("\nCREATING NEW SERVICESPECIFICATION \n");
            ServiceSpecification serviceSpecification = new ServiceSpecification();
            serviceSpecification.setVersion((String)lhm.get("version"));
            serviceSpecification.setName((String)lhm.get("name"));
            serviceSpecification.setId((String)lhm.get("id"));
            serviceSpecification.setHref((String)lhm.get("href"));
            this.setServiceSpecification(serviceSpecification);
        }
    }

    /*
    //TODO be able to update id of object, currently not working, not part of the API
    //Updates / removes the relationship between a service and a ServiceSpecification to the given id
    public void customSetServiceSpecification(Integer id, String op) {

        System.out.println("Entered Integer changer");
        String lewl = id.toString();
        System.out.println("Set lewl to " + lewl);
        Long lul = new Long(lewl);
        System.out.println("Set lul to " + lul);

        EntityHelper eh = new EntityHelper();
        System.out.println("Created EntityHelper");

        ServiceSpecification ser = eh.findById(lul);
        System.out.println("Found ServiceSpecification by id, = " + ser);
        this.setServiceSpecification(ser);
        System.out.println("\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID\nChange ID");
    }
    */

    public Set<Place> getPlace() {
        return places;
    }

    public void setPlace(Set<Place> places) {
        for(Place place : places) {
            this.places.add(place);
            place.setService(this);
        }
    }

    public Set<Note> getNote() {
        return notes;
    }

    public void setNote(Set<Note> notes) {
        for(Note note : notes) {
            this.notes.add(note);
            note.setService(this);
        }
    }

    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public List<RelatedParty> getRelatedParty() {
        return relatedParties;
    }

    public Set<ServiceCharacteristic> getServiceCharacteristics() {
        return serviceCharacteristics;
    }

    public void setServiceCharacteristics(Set<ServiceCharacteristic> serviceCharacteristics) {
        for(ServiceCharacteristic serviceCharacteristic : serviceCharacteristics) {
            this.serviceCharacteristics.add(serviceCharacteristic);
            serviceCharacteristic.setService(this);

        }
    }

    public Set<ServiceRelationship> getServiceRelationships() {
        return serviceRelationships;
    }

    public void setServiceRelationships(Set<ServiceRelationship> serviceRelationships) {
        for(ServiceRelationship serviceRelationship : serviceRelationships) {
            this.serviceRelationships.add(serviceRelationship);
            serviceRelationship.setService(this);
        }
    }

    public List<SupportingResource> getSupportingResources() {
        return supportingResources;
    }

    public List<SupportingService> getSupportingServices() {
        return supportingServices;
    }
}
