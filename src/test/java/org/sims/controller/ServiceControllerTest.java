package org.sims.controller;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.CaseBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sims.model.QService;
import org.sims.model.Service;
import org.sims.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.persistence.EntityManager;

import java.util.Map;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebMvcTest(ServiceController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ServiceControllerTest {

    @Autowired
    private ServiceController serviceController;

//    @MockBean
//    private ServiceController serviceController;

    //TODO start writing tests...
    @Test
    public void getService() throws Exception {

        QService service = QService.service;
        Predicate predicate = service.isNotNull();
        System.out.println(predicate);

        BooleanBuilder bb = new BooleanBuilder(predicate);

        System.out.println(bb.toString());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();


        MultiValueMap<String, String> args = map;
        System.out.println(args);
        System.out.println("Created args and predicate");


        System.out.println(". RequestParam = " + args);
        System.out.println("Params tostring = " + args.toString());
        System.out.println(args.toSingleValueMap().toString());
        System.out.println(args.keySet());
        System.out.println(args.size());
        System.out.println(args.entrySet().toString());
        System.out.println(args.isEmpty());
        System.out.println(args.values());
        System.out.println(args.getClass());


        System.out.println("Servicecontroller = " + serviceController);

        MappingJacksonValue mjv = serviceController.getServicee(1L, args);
        System.out.println("Performed getService");

//        given(serviceController.getService(1L, args, predicate)).willReturn(null);
        System.out.println("performed given - will return");

        if(mjv == null) {
            System.out.println("mjv = null");
        }
        System.out.println();


        Object o = mjv.getValue();
        Optional<Service> ser = (Optional<Service>) o;
        Service s = ser.get();

        System.out.println("Name and category for service = " + s.getName() + s.getCategory());



//        mvc.perform(get("/service/1")
//        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)));
//        System.out.println("end of test");

    }

//
//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Autowired
//    ServiceController serviceController;
//
//    @Test
//    public void getServices() {
////        MultiValueMap<String, String> args = new LinkedMultiValueMap<>();
////
////        Predicate predicate = new BooleanBuilder();
////
////        Service s = (Service)serviceController.getService(1L, args, predicate).getValue();
////        System.out.println(s);
//        assertNull(null);
//
//    }

//    @Test
//    public void getService() {
//    }
//
//    @Test
//    public void createService() {
//    }
//
//    @Test
//    public void deleteService() {
//    }
//
//    @Test
//    public void patchService() {
//    }
}