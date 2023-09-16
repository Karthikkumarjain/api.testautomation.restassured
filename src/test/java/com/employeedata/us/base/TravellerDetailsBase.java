package com.employeedata.us.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;

public class TravellerDetailsBase {

    @BeforeEach
    void setUp(){

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setAccept(ContentType.XML).addFilter(new RequestLoggingFilter()).addFilter(new ResponseLoggingFilter()).build();


        RestAssured.responseSpecification =  new ResponseSpecBuilder()
                .expectStatusCode(200).build();
    }
}
