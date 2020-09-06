package com.restfulservices.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="Employee")
@ApiModel(description = "Employee description")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;

    @Column(name = "name",nullable = false)
    @Size(min = 2,message = "Employee name must contain atleast 2 characters")
    private String empName;

    @Column(name="email",nullable = false)
    @Size(min = 4,message = "Email should contain a format like 'a@b.com' ")
    private String emailId;

    @Past
    //@Future
    @ApiModelProperty(notes="Birth Date should be in past..")
    private Date birthDate;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Employee() {
    }

    public Employee(String empName, String emailId) {
        this.empName = empName;
        this.emailId = emailId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
