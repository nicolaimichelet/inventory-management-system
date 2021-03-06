package org.sims.controller;

import com.querydsl.core.types.Predicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sims.model.QService;
import org.sims.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceControllerTest {

  @Autowired
  private ServiceController serviceController;

  @Before
  public void setUp() {

  }

  @After
  public void tearDown() {
  }

  @Test
  public void getService() {
    QService service = QService.service;
    Predicate predicate = service.isNotNull();
    MultiValueMap<String, String> args = new LinkedMultiValueMap<>();
    MappingJacksonValue mjv = serviceController.getService(1L, args, predicate);
    if (mjv == null) {
      fail();
    }
    Object o = mjv.getValue();
    Optional<Service> ser = o instanceof Optional ? ((Optional) o) : Optional.empty();
    if(!ser.isPresent()) {
      fail();
    }
    Service s = ser.get();
    assertEquals("name1", s.getName());
  }

  @Test
  public void getServices() {
    QService service = QService.service;
    Predicate predicate = service.isNotNull();
    MultiValueMap<String, String> args = new LinkedMultiValueMap<>();
    MappingJacksonValue mjv = serviceController.getServices(args, predicate);
    if (mjv == null) {
      fail();
    }
    Object o = mjv.getValue();
    List<Service> serv = o instanceof List ? ((List) o) : null;
    if(serv == null) {
      fail();
    }
    assertEquals("name1", serv.get(0).getName());
    assertEquals("name2", serv.get(1).getName());
  }

  @Test
  public void createService() {
    Service service = new Service();
    service.setName("createdServiceName");
    service.setCategory("createdServiceCategory");
    serviceController.createService(service);

    QService qService = QService.service;
    Predicate predicate = qService.isNotNull();
    MultiValueMap<String, String> args = new LinkedMultiValueMap<>();

    MappingJacksonValue mappingJacksonValue = serviceController.getService(3L, args, predicate);
    Object object = mappingJacksonValue.getValue();
    Optional<Service> optionalService = object instanceof Optional ? ((Optional) object) : Optional.empty();
    if(!optionalService.isPresent()) {
      fail();
    }
    Service createdService = optionalService.get();
    assertEquals("createdServiceName", createdService.getName());
    assertEquals("createdServiceCategory", createdService.getCategory());
  }

  @Test
  public void deleteService() {
    Service service = new Service();
    service.setName("createdServiceName");
    service.setCategory("createdServiceCategory");
    serviceController.createService(service);

    QService qService = QService.service;
    Predicate predicate = qService.isNotNull();

    MultiValueMap<String, String> args = new LinkedMultiValueMap<>();
    MappingJacksonValue mappingJacksonValue = serviceController.getService(3L, args, predicate);
    Object object = mappingJacksonValue.getValue();
    Optional<Service> optionalService = object instanceof Optional ? ((Optional) object) : Optional.empty();

    if(!optionalService.isPresent()) {
      fail();
    }
    Service createdService = optionalService.get();

    assertEquals("createdServiceName", createdService.getName());
    assertEquals("createdServiceCategory", createdService.getCategory());

    serviceController.deleteService(3L);
    Object emptyServiceObject = serviceController.getService(3L, args, predicate).getValue();
    Optional<Service> optionalEmptyService = emptyServiceObject instanceof Optional ? ((Optional) emptyServiceObject) : Optional.empty();
    assertTrue(!optionalEmptyService.isPresent());
  }

  //TODO
  @Test
  public void patchService() {
  }
}