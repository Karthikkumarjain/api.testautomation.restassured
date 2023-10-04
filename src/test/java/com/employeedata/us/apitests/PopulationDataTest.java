package com.employeedata.us.apitests;

import com.employeedata.us.base.PopulationDataBase;
import com.employeedata.us.constants.FrameworkConstants;
import com.employeedata.us.endpoints.PopulationDataEndpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

class PopulationDataTest extends PopulationDataBase {


    @Test
    @DisplayName("Verify the Population Data service is up and running")
    void verifyTheServiceIsUpTest() {


        given().when()
                .get(PopulationDataEndpoint.ENDPOINT)
                .then().assertThat()
                .statusCode(equalTo(200))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(FrameworkConstants.getInstance().getResponseSchemaPathJson()+"PopulationData.json"));

    }


}
