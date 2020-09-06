package com.restfulservices.service;

import com.restfulservices.beans.Employee;
import com.restfulservices.exception.EmployeeException;
import com.restfulservices.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
        /*orElseThrow(()->new EmployeeException("Employee Does Not Found with id "+id));*/
    }

    public Employee saveEmployee(Employee employee){
        Employee emp = null;
        if(employee!=null){
            emp=employeeRepository.save(employee);
        }
        if (emp == null) {
            throw new EmployeeException("Problem in creating Employee!!");
        }
        else{
            return emp;
        }
    }

    public Employee updateEmployeeDetails(Employee employee){
        Optional<Employee> emp=employeeRepository.findById(employee.getEmpId());
        if(emp.isPresent()){
             return employeeRepository.save(employee);
        }
        else{
            throw new EmployeeException("Employee does not exist with id"+employee.getEmailId());
        }
    }

   public boolean deleteEmployee(String empId){
        if (!employeeRepository.existsById(Long.valueOf(empId))) {
            throw  new EmployeeException("No Employee exist with this employee Id"+empId);
        } else {
           return employeeRepository.deleteByEmpId(Long.valueOf(empId));
        }
    }
}
