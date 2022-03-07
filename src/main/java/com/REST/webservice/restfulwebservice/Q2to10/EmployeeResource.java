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

    @GetMapping("/employee")
    public List<Employee> retriveAllUsers(){

        return service.findAll();

    }


    //Implement GET http request using path variable top get one employee.
    //Through Path Variable we can set path for respective finding elemnet.

    @GetMapping("/employee/{id}")
    public Employee retrieveUser(@PathVariable int id) {
        Employee employee = service.findOne(id);
        if (employee == null) {
            throw new UserNotFoundException("id" + id);
        }
        return employee;
    }

    //Delete http request for Employee to delete employee
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
    @PutMapping("/updateid")
    public  String updateid(@RequestBody Employee employee){
       return service.updateid(employee);
    }


}
