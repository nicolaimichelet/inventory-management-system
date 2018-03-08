package org.sims.discovery.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.reactivestreams.Subscription;
import org.sims.discovery.IDiscoveryService;
import org.sims.discovery.IService;
import org.sims.model.Service;
import org.sims.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import io.reactivex.disposables.Disposable;

public class DiscoveryManager{
  
  @Autowired
  ServiceRepository serviceRepo;

  List<IDiscoveryService> discoveryServices = new ArrayList<IDiscoveryService>();
  Set<Class<? extends IDiscoveryService>> serviceClasses = new HashSet<Class<? extends IDiscoveryService>>();

  // Map IService to database entry 
  Map<IService, Long> databaseMap = new HashMap<IService, Long>(50);
  
  // Map UUID to IService
  Map<String, IService> serviceMap = new HashMap<String, IService>(50);

  //List of disposable subscriptions
  List<Disposable> subscriptions = new ArrayList<Disposable>();
  
  public DiscoveryManager(){
    //this.serviceRepo = serviceRepo;
  }


  public void registerDiscovery(Class<? extends IDiscoveryService> serviceClass){
    
    serviceClasses.add(serviceClass);
    // find all services managed by this class
    
  }

  public void initAll(){
    for(Class<? extends IDiscoveryService> discovery : serviceClasses){
      try{
        IDiscoveryService service = discovery.getConstructor().newInstance();
        discoveryServices.add(service);
        subscriptions.add(service.serviceAdded().subscribe(this::addService));
        subscriptions.add(service.serviceRemoved().subscribe(this::removeService));
        service.probeServices().subscribe((List<IService> services) -> {
          services.forEach((IService s) -> {
            this.addService(s);
          });
        });
      }catch(Exception e) {
        System.err.println(e);
      }
    }
  }

  public void startAll(){
    for(IDiscoveryService service : discoveryServices){
      service.start();
    }
  }

  public void stopAll(){
    for(IDiscoveryService service : discoveryServices){
      service.stop();
    }
  }

  // Disposes all service discovery
  public void disposeAll(){
    for(Disposable subscription : subscriptions){
      subscription.dispose();
    }
    
    for(IDiscoveryService service : discoveryServices){
      service.dispose();
    }
    discoveryServices = new ArrayList<IDiscoveryService>(discoveryServices.size());
  }

  //Returns a list of active discovery services
  public List<IDiscoveryService> getRunning(){
    return discoveryServices.stream()
      .filter((IDiscoveryService e) -> e.isRunning())
      .collect(Collectors.toList());
  }

  //Service was discovered
  private void addService(IService s){
    String UUID = s.getUUID();
    Service example = new Service();
    example.setUuid(UUID);

    Service res = serviceRepo.findOne(Example.of(example));
    Service entry = new Service();
    if(res == null){
      System.out.println("Service does not already exist creating");
      // Map IService to Service, should be moved to helper method
      entry.setUuid(UUID);
      entry.setHasStarted(s.hasStarted());
      entry.setDescription(s.getDescription());
      entry.setCategory("MANAGED");
    } else {
      // Update record
      entry = res;
    }
    entry.setName(s.getName());
    entry.setHref(s.getHref());
      
    serviceRepo.save(entry);
    
  }

  //Service was lost
  private void removeService(IService s){
    String UUID = s.getUUID();
    Service example = new Service();
    example.setUuid(UUID);

    Service res = serviceRepo.findOne(Example.of(example));
    if(res == null){
      System.out.println("Service was not tracked");
    } else {
      // Delete service
      System.out.println("Service deleted");
      serviceRepo.delete(res);
    }
  
  }

}