package org.sims.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class ServiceOrder {
  //Columns
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String href;

  // Relations
  @OneToMany(mappedBy = "serviceOrder")
  private List<Service> services = new ArrayList<>();

  public ServiceOrder() {}

//  public ServiceOrder(String href) {
//    this.href = href;
//  }

  public void addServices(List<Service> services) {
    for (Service service : services) {
    this.services.add(service);
    }
  }

  public void removeServices(List<Service> services) {
    for (Service service : services) {
      this.services.remove(service);
    }
  }


  public void setHref(String href) {
    this.href = href;
  }

  public String getHref() {
    return href;
  }
}
