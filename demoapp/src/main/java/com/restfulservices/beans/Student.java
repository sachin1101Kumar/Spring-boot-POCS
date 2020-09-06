package com.restfulservices.beans;



import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

//@JsonIgnoreProperties(value = {"age","course"})
@JsonFilter("studentbeanfilter")
public class Student {
    private String name;
    private String course;
    @JsonIgnore
    /*Field which you do not want to send in a response that field you can annotate with @json ignore annotation*/
    private String age;

    public Student(String name, String course, String age) {
        this.name = name;
        this.course = course;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
