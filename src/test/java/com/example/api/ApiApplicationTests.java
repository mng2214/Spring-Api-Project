package com.example.api;

import com.example.api.Requests.ReqSpec;
import com.example.api.Responses.GetUsersResponse;
import com.example.api.Responses.ResSpec;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

//@SpringBootTest
class ApiApplicationTests {

    @Test
    void testAllUsersPositive() throws JsonProcessingException {

        Response response = RestAssured
                .given(ReqSpec.reqSpec)
                .get("/user/all")
                .then().spec(ResSpec.resSpec())
                .extract().response();

        List<GetUsersResponse> users = new ObjectMapper()
                .readValue(response.getBody()
                        .asString(), new TypeReference<>() {
        });
        Assertions.assertEquals(10, users.size());

        //  users.stream().map(GetUsersResponse::getId).forEach(System.out::println);
    }

    @Test
    public void testGetUserPositive() {
        given().spec(ReqSpec.reqSpec)
                .when()
                .get("/user/{id}", 2)
                .then().spec(ResSpec.resSpec())
                .statusCode(200)
                .body("id", equalTo(2));

    }
}
