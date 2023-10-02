package com.restapibase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

    // Basic Funtions
    public static Response getRequest(String requestUrl){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.get(requestUrl);
        return response;
    }

    public static Response postRequest(String requestUrl, String requestPayload, String bearer_token){
        RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization","Bearer " + bearer_token);
        Response response = requestSpecification.post(requestUrl);
        return response;
    }

    public static Response deleteRequest(String deletendpoint, String bearer_token) {
        //  RequestSpecification requestSpecification = RestAssured.given().body(deletendpoint);
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization","Bearer " + bearer_token);
        Response response = requestSpecification.delete(deletendpoint);
        return response;
    }
}
