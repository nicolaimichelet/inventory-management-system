package org.sims.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController{

  @RequestMapping(method=RequestMethod.GET, value="/greeting")
  public HashMap<String, String> greeting(@RequestParam(value="name", defaultValue="World") String name){
    HashMap<String, String> response = new HashMap<String, String>(10);
    response.put("greeting", String.format("Hello %s", name));
    
    return response;
  }
}