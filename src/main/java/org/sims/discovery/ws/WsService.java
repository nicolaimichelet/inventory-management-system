package org.sims.discovery.ws;

import org.sims.discovery.IService;


public class WsService implements IService{
  protected String address = "";
  protected String UUID = "";
  
  
  public String getAddress(){
    return address;
  }

  public String getUUID(){
    return String.format("ws:%s",UUID);
  }
}