package com.REST.webservice.restfulwebservice.Q2to10;

import org.springframework.boot.convert.DataSizeUnit;

public class Employee {
    private Integer id;


    private  String name;
    private  Integer age;


    //For Post making Default Construtor
    protected  Employee(){
         //No-argument Constructor

    }


    //Created Employee Bean
    public Employee(Integer id, String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
