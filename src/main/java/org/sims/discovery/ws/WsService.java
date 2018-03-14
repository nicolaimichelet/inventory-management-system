package org.sims.discovery.ws;

import java.net.URI;
import java.util.Date;

import javax.xml.namespace.QName;

import com.ms.wsdiscovery.servicedirectory.WsDiscoveryService;

import org.sims.discovery.IService;



public class WsService implements IService{
  private WsDiscoveryService service;
  final private String href;
  final private String UUID;
  final private String name = "Some ws discovery service";
  final private Date discoveredDate = new Date();

  public WsService(WsDiscoveryService service){
    this.service = service;
    UUID = String.format("ws:%s", service.getEndpointReference().getAddress());
    href = service.getXAddrs().get(0);

  }

  public Date getDiscovered(){
    return discoveredDate;
  }
    
  public String getHref(){
    return href;
  }

  public String getUUID(){
    return UUID;
  }

  public String getName(){
    return name;
  }

  public String getDescription(){
    return "WS-Discovery service";
  }

  public boolean hasStarted(){
    return true;
  }

}