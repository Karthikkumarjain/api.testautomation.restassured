package com.employeedata.us.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.*;

public class EmployeeCreationBase {

    @BeforeEach
    public void setUp() {

        requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();

        responseSpecification = new ResponseSpecBuilder().expectStatusCode(201).build();

    }
}
