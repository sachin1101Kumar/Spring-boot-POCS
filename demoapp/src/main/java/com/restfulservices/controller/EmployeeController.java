package com.restfulservices.controller;

import com.restfulservices.beans.Employee;
import com.restfulservices.exception.EmployeeException;
import com.restfulservices.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    Employee emp=null;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/all-employees")
    public List<Employee> getAllEmployees(){
            return employeeService.getAllEmployees();
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> findEmpById(@PathVariable(value = "id") Long id) throws EmployeeException{
          Optional<Employee> empl=employeeService.getEmployeeById(id);
          if(empl.isPresent())
              return ResponseEntity.ok().body(empl.get());
          /*else {
              return ResponseEntity.noContent().build();
          }*/
        else{
              empl.orElseThrow(()->new EmployeeException("Employee Does Not Exist with id "+id));
              return ResponseEntity.noContent().build();
          }
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
       emp= employeeService.saveEmployee(employee);
        //URI uri = ;
        return ResponseEntity.ok().body(emp);
    }
    @PostMapping("/createEmp&Uri")
    public EntityModel<Employee> createEmployeeAndUri(@RequestBody Employee employee){
        emp= employeeService.saveEmployee(employee);
        //Implementing the concept of spring Hateos(Returning the link with data)
        EntityModel<Employee> resource = EntityModel.of(emp);

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllEmployees());

        resource.add(linkTo.withRel("all-employees"));

        return resource;
    }

    @PostMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        emp=employeeService.updateEmployeeDetails(employee);
        return ResponseEntity.ok().body(emp);
    }

   /* @GetMapping("/sayhello")
    public String checkInternationlaization(@RequestHeader(name = "Accept-Language",required = false ) Locale locale){
        return messageSource.getMessage("good.morning.message",null,locale);
    }*/

    @GetMapping("/sayhello")
    public String checkInternationlaization() {
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }

}
