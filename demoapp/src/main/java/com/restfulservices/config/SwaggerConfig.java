package com.restfulservices.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
/*If we do not make any changes to this class it will work as it
is but if we want to make some changes in the APi documentation then we need to override some of the metheods*/
public class SwaggerConfig {

    public static final springfox.documentation.service.Contact DEFAULT_CONTACT = new Contact("sachin kumar", "http://localhost:8080/swagger-ui.html", "tech.sachinkumar@gmail.com");

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2);
    }

}
