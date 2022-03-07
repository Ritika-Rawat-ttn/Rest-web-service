package com.REST.webservice.restfulwebservice.Q2to10;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {


    @Autowired
    private EmployeeService service;




    //Implement GET request for Employee to get list of employees.
    //retriveing all the list of employee.
//GET Mapping-The @GetMapping annotated methods in the @Controller annotated classes handle the HTTP GET requests matched with given URI expression.

//Q3-
    @GetMapping("/employee")
    public List<Employee> retriveAllUsers(){

        return service.findAll();

    }


    //Implement GET http request using path variable top get one employee.
    //Through Path Variable we can set path for respective finding elemnet.
    //Q4

    @GetMapping("/employee/{id}")
    public Employee retrieveUser(@PathVariable int id) {
        Employee employee = service.findOne(id);
        if (employee == null) {
            throw new UserNotFoundException("id" + id);
        }
        return employee;
    }

    //Delete http request for Employee to delete employee
    //Q-7


    @DeleteMapping("/employee/{id}")
    public Employee deleteUser(@PathVariable int id) {
        Employee employee = service.deletebyId(id);
        if (employee == null) {
            throw new UserNotFoundException("id" + id);
        }
        return employee;
    }


    //Created Post as CreatEmployee
    //Details of all CreateEmployee
    //PoST mapping-@PostMapping is used for HTTP Post request.
    //Q-5


    @PostMapping("/employee")
    public ResponseEntity<Object>CreateEmployee(@Validated @RequestBody Employee employee){
        Employee SavedEmployee = service.save(employee);

        //CREATED
        //URI in comment is /employee/{id} is now replaced by SavedEmployee.get.id()

        //setting uri
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(SavedEmployee.getId()).toUri();
        return ResponseEntity.created(location).build();


    }

    //PUt mapping - PUT HTTP method is used to modify/update a resource where the client sends data that updates the entire resource.
    //Q-8
    @PutMapping("/updateid")
    public  String updateid(@RequestBody Employee employee){
       return service.updateid(employee);
    }


}
