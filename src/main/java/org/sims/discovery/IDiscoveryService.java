package org.sims.discovery;
import java.util.List;

import org.reactivestreams.Publisher;

import io.reactivex.Observable;
import io.reactivex.Single;


public interface IDiscoveryService{

  // emitts when service is discovered
  public Observable<IService> serviceAdded();
  // emitts when service is updated
  public Observable<IService> serviceUpdated();
  // emitts when service no longer available
  public Observable<IService> serviceRemoved();
  // Probes one time and returns services found
  public Single<List<IService>> probeServices();
  // Should start notifying
  public void start(); // Starts 'discovery
  // Should stop notifying
  public void stop();
  // Should dispose of all resources used by the service discoverer, should not be able to recover from this
  public void dispose(); 
}