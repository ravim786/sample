package com.tutotial.dmn.resources;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import com.tutotial.dmn.KogitoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = KogitoApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TrafficViolationTest {

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testViolation() {
        RestAssured.port = randomServerPort;
        given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .body("{" + "\"Driver\": {" + "\"Points\": 2" + "}," + "\"Violation\": {" + "\"Type\": \"speed\","
                        + "\"Actual Speed\": 120," + "\"Speed Limit\": 100" + "}" + "}")
                .when().post("/demo/trafficViolation").then().statusCode(200)
                .body("'Should the driver be suspended?'", equalTo("No"));

    }

}
