package org.sims.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "serviceorder")
public class ServiceOrder {
    //Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String href;

    // Relations
    @OneToMany(
            mappedBy = "serviceOrder",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Service> services = new ArrayList<>();

    public ServiceOrder() {

    }

    public ServiceOrder(String href) {
        this.href = href;
    }

//    public void setService(Service service) {
//        this.services.add(service);
//    }


    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }
}
