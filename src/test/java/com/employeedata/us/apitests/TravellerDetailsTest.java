package com.employeedata.us.apitests;

import com.employeedata.us.EmployeeData;
import com.employeedata.us.base.TravellerDetailsBase;
import com.employeedata.us.constants.FrameworkConstants;
import com.employeedata.us.endpoints.TravellerDetailsEndpoint;
import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class TravellerDetailsTest  extends TravellerDetailsBase {


    @Test
    void verfiyServiceisUpTest(){


        given().
                when()
                .get(TravellerDetailsEndpoint.ENDPOINT)
                .then()
                .body(RestAssuredMatchers.matchesXsdInClasspath(FrameworkConstants.getInstance().getResponseSchemaPathXml()+"travellerdetails.xsd"));


    }
}
