package com.REST.webservice.restfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class WelcomeController {
    //method-"Welcome to Spring boot


    @GetMapping(path = "/welcome" )
    public String Welcome(){
        return "Welcome to Spring boot";
    }

}
