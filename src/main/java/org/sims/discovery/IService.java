package org.sims.discovery;

import java.util.Date;

public interface IService {
  public String getUUID();
  public String getHref();
  public String getDescription();
  public String getName();
  public Date getDiscovered();
  public boolean hasStarted();
}