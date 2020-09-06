package com.restfulservices.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.restfulservices.beans.Student;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/getstudent")
    public MappingJacksonValue getStudentBean(){
         Student student=new Student("Sachin","Spring Boot","31");

         SimpleBeanPropertyFilter simpleBeanPropertyFilter=SimpleBeanPropertyFilter.filterOutAllExcept("name","age");

         FilterProvider provider=new SimpleFilterProvider().addFilter("studentbeanfilter",simpleBeanPropertyFilter);
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(student);
        mappingJacksonValue.setFilters(provider);

        return mappingJacksonValue;
    }

    @GetMapping("/get-all")
    public List<Student> getAllStudents(){
        return Arrays.asList(new Student("sachin","spring","31"),
                new Student("sachin 1","spring1","32"));
    }
}
