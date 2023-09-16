package com.employeedata.us.apitests;

import com.employeedata.us.base.PopulationDataBase;
import com.employeedata.us.endpoints.PopulationDataEndpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

class PopulationDataTest extends PopulationDataBase {


    @Test
    void verifyTheServiceIsUpTest() {


        given().when()
                .get(PopulationDataEndpoint.ENDPOINT)
                .then().assertThat()
                .statusCode(equalTo(200))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/json/PopulationData.json"));

    }


    @Test
    void verifyTheResponseContent() {


        Response response = given().when().get(PopulationDataEndpoint.ENDPOINT).then().extract().response();

        //    List<Map<String,?>> nationName = response.path("data.findAll {it.Nation == 'United States'}");
        String nationName = response.jsonPath().getString("?[?(@.Nation=='United States')].Nation");

        System.out.println(nationName);

    }


}
