package org.sims.discovery;
import java.util.List;

import org.reactivestreams.Publisher;

import io.reactivex.Observable;
import io.reactivex.Single;


public interface IDiscoveryService{


  public Observable<IService> serviceAdded(); // emitts when service is created
  public Observable<IService> serviceUpdated();
  public Observable<IService> serviceRemoved(); // emitts when service no longer exists
  public Single<List<IService>> probeServices(); // One time probe
  public void start(); // Starts discovery
  public void stop(); // Should stop the service discovery, disable notify
  public void dispose(); // Should dispose of all resources used by the service discoverer
}