package com.REST.webservice.restfulwebservice;
import com.REST.webservice.restfulwebservice.Q1.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class WelcomeController<SpringBootBean> {
    //method-"Welcome to Spring boot


    @GetMapping(path = "/welcome" )
    public String Welcome(){
        return "Welcome to Spring boot";
    }



    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Welcome to spring boot");
    }


}
