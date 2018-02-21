package org.sims.discovery.ws;

import com.ms.wsdiscovery.servicedirectory.WsDiscoveryService;

import org.sims.discovery.IService;


public class WsService implements IService{
  private WsDiscoveryService service;
  final protected String address;
  final protected String UUID;

  public WsService(WsDiscoveryService service){
    this.service = service;
    UUID = String.format("ws:%s", service.getEndpointReference().getAddress());
    address = service.getPortTypes().toString();
  }
 
    
  public final String getAddress(){
    return address;
  }

  public final String getUUID(){
    return UUID;
  }
}