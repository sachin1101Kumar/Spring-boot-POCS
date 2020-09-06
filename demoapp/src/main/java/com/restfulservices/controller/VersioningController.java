package com.restfulservices.controller;

import com.restfulservices.beans.PersonV1;
import com.restfulservices.beans.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
  /*Metheod 1 :Separating the Url itself for two versions*/
    /*@GetMapping("/person/v1")
    public PersonV1 getPersonV1(){
        return new PersonV1("sachin");
    }

    @GetMapping("/person/v2")
    public PersonV2 getPersonV2(){
        return  new PersonV2("sachin","kumar");
    }*/

    /*Separating the  param values*/
    /*http://localhost:8080/person/param?version=1 or 2*/
    @GetMapping(value="/person/param",params = "version=1")
    public PersonV1 getPersonV1(){
        return new PersonV1("sachin");
    }

    @GetMapping(value="/person/param",params = "version=2")
    public PersonV2 getPersonV2(){
        return  new PersonV2("sachin","kumar");
    }
    /*Separating using the header params*/
    /*http://localhost:8080/person/param in header section need to pass X-API-VERSION=1 or 2*/
    @GetMapping(value="/person/header",headers = "X-API-VERSION=1")
    public PersonV1 getHeaderV1(){
        return new PersonV1("sachin");
    }

    @GetMapping(value="/person/header",headers = "X-API-VERSION=2")
    public PersonV2 getHeaderV2(){
        return  new PersonV2("sachin","kumar");
    }

    /*Separating API using produces options*/
    /*http://localhost:8080/person/param in header section need to pass Accept =application/vnd.company.app-v1+json/application/vnd.company.app-v2+json*/
    @GetMapping(value="/person/produces",produces = "application/vnd.company.app-v1+json")
    public PersonV1 getProducesV1(){
        return new PersonV1("sachin");
    }

    @GetMapping(value="/person/produces",produces = "application/vnd.company.app-v2+json")
    public PersonV2 getProducesV2(){
        return  new PersonV2("sachin","kumar");
    }


}
