package com.example.api.Requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ReqSpec {
    public static RequestSpecification reqSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .setBaseUri("http://localhost")
            .setPort(8081)
            .log(LogDetail.ALL)
            .build();
}
