package org.sims.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ServiceSpecification {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long dbid;

  private String href;
  private String id;
  private String name;
  private String version;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "serviceSpecification")
  private Service service;

  @JsonIgnore
  public Long getDbid() {
    return dbid;
  }
  public void setDbid(Long dbid) {
    this.dbid = dbid;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }
  public void setHref() {
    this.href = null;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  public void setId() {
    this.id = null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setName() {
    this.name = null;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }
  public void setVersion() {
    this.version = null;
  }

}
