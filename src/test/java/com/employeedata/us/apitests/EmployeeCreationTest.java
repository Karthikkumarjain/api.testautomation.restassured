package com.employeedata.us.apitests;

import com.employeedata.us.EmployeeData;
import com.employeedata.us.base.EmployeeCreationBase;
import com.employeedata.us.constants.FrameworkConstants;
import com.employeedata.us.endpoints.EmployeeCreationEndpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

class EmployeeCreationTest extends EmployeeCreationBase {


    @Test
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
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(FrameworkConstants.getInstance().getResponseSchemaPathJson()+"createEmployeeData.json"))
                .body("name",equalTo("TestDataName"))
                .extract().response();

    }
}
