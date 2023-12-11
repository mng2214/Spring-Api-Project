package com.example.api;

import com.example.springApi.api.controller.UserController;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.lessThan;

import java.util.List;


//@SpringBootTest
class ApiApplicationTests {

    RequestSpecification reqSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .setBaseUri("http://localhost")
            .setPort(8081)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification resSpec() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .expectResponseTime(lessThan(5000L))
                .build();
    }

    @Test
    void testAllUsersPositive() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Response response = RestAssured
                .given(reqSpec)
                .get("/allusers")
                .then().spec(resSpec())
                .statusCode(200)
                .extract().response();
        List<GetUsersResponse> users = mapper.readValue(response.getBody().asString(), new TypeReference<>() {
        });
        Assertions.assertEquals(20, users.size());
    }

    @Test
    void testAllUsersNegative() {

        RestAssured
                .given(reqSpec)
                .param("id", "2")
                .get("/user")
                .then().spec(resSpec())
                .statusCode(404)
                .extract().response();
    }


}
