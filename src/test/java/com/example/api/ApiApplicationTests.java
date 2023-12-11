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

//@SpringBootTest
class ApiApplicationTests {

    @Test
    void testAllUsersPositive() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Response response = RestAssured
                .given(ReqSpec.reqSpec)
                .get("/allusers")
                .then().spec(ResSpec.resSpec())
                .statusCode(200)
                .extract().response();
        List<GetUsersResponse> users = mapper.readValue(response.getBody().asString(), new TypeReference<>() {
        });
        Assertions.assertEquals(20, users.size());

        users.stream().map(GetUsersResponse::getId).forEach(System.out::println);
    }

    @Test
    void testAllUsersNegative() {

        RestAssured
                .given(ReqSpec.reqSpec)
                .param("id", "2")
                .get("/user")
                .then().spec(ResSpec.resSpec())
                .statusCode(404)
                .extract().response();
    }


}
