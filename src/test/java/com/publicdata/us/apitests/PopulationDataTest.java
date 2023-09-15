package com.publicdata.us.apitests;

import com.publicdata.us.base.PopulationDataBase;
import com.publicdata.us.endpoints.PopulationDataEndpoint;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

class PopulationDataTest extends PopulationDataBase {


    @Test
    void verifyTheServiceIsUpTest() {


        given()
                .when().get(PopulationDataEndpoint.ENDPOINT)
                .then().assertThat().statusCode(equalTo(200));

    }


    @Test
    void verifyTheResponseContent() {


        Response response = given().when().get(PopulationDataEndpoint.ENDPOINT)
                .then().extract().response();

        List<Map<String,?>> nationName = response.path("data.findAll {it.Nation == 'United States'}");


        System.out.println(nationName);
    }

}
