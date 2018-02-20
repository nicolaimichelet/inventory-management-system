package org.sims.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "serviceorders")
public class ServiceOrder {
    //Columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String href;

    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = true)
    private Service service;

    public ServiceOrder() {

    }

    public ServiceOrder(String href) {
        this.href = href;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }
}
