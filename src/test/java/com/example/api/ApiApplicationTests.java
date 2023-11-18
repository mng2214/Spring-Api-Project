package com.example.api;

import com.jayway.jsonpath.TypeRef;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

//@SpringBootTest
class ApiApplicationTests {

	@Test
	void contextLoads() {
	Response res = RestAssured.given().accept(ContentType.JSON)
				.when().log().all()
				.get("/allusers")
				.then().log().all()
			.extract().response();

	}

}
