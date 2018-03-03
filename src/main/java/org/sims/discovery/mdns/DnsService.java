package org.sims.discovery.mdns;

import javax.jmdns.ServiceInfo;

import org.sims.discovery.IService;

public class DnsService implements IService{
  private ServiceInfo info;

  public DnsService(ServiceInfo info){
    this.info = info;
  }


  public String getUUID(){
    return String.format("dns:%s",info.getKey());
  }

  public String getAddress(){
    return info.getPropertyString("path");
  }
}