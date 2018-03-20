package org.sims.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ServiceSpecification")
@Table(name = "servicespecification")
public class ServiceSpecificationRef {

  // Columns
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String href;

  private String name;

  private String version;

  // Relations
  @OneToOne(fetch = FetchType.LAZY, mappedBy = "serviceSpecificationRef")
  //@JoinColumn(name = "service_id")
  private Service service;

  public ServiceSpecificationRef() {
  }

  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public String getHref() {
    return href;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getVersion() {
    return version;
  }
}
