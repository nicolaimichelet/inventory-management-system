package org.sims.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sims.Main;
import org.sims.model.Service;
import org.sims.repository.ServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class ServiceControllerTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    EntityManager em;

    @Autowired
    ServiceController sc;

    /*
    //TODO write tests
    @Test
    public void findById_basic() {
        MappingJacksonValue service = sc.getService(1L, null, null);
        System.out.println("Retrieved service = " + service);
        Object o = service.getValue();
        System.out.println("Got value from MappingJacksomValue = " + o);
        Service s = (Service)o;
        System.out.println("Casted Object to Service = " + s);
        assertEquals("name1", s.getName());
    }
    */


}
