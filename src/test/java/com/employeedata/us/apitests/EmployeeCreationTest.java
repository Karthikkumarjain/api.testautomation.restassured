package com.employeedata.us.apitests;

import com.employeedata.us.EmployeeData;
import com.employeedata.us.base.EmployeeCreationBase;
import com.employeedata.us.constants.FrameworkConstants;
import com.employeedata.us.endpoints.EmployeeCreationEndpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

class EmployeeCreationTest extends EmployeeCreationBase {


    @Test
    @DisplayName("Create Employee Data service is up and running")
    void EmployeeCreationServiceTest() {

        EmployeeData employeeData = new EmployeeData().builder()
                .name("TestDataName")
                .job("Developer")
                .build();

        Response response = given()
                .body(employeeData)
                .when()
                .post(EmployeeCreationEndpoint.ENDPOINT)
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(FrameworkConstants.getInstance().getResponseSchemaPathJson() + "createEmployeeData.json"))
                .body("name", equalTo("TestDataName"))
                .extract().response();

        EmployeeData empData = response.getBody().as(EmployeeData.class);
        //  System.out.println(empData.getJob());
        assertThat(empData.getJob()).isEqualTo("Developer");
        assertThat(response.getStatusCode()).isEqualTo(201);


    }
}