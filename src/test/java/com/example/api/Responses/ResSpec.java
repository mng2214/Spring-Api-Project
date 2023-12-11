package com.example.api.Responses;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class ResSpec {
    public static ResponseSpecification resSpec() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .expectResponseTime(lessThan(5000L))
                .build();
    }
}
