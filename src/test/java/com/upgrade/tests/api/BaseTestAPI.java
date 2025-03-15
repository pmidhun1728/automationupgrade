package com.upgrade.tests.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class BaseTestAPI {
    protected static RequestSpecification request;
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public BaseTestAPI() {
        RestAssured.baseURI = ConfigReader.getProperty("base_url");
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
    }

    public Response getRequest(String endpoint){
        return request.get(endpoint);
    }

    public Response postRequest(String endpoint, Object body) {
        try {

            String jsonBody = objectMapper.writeValueAsString(body);
            return request.body(jsonBody).post(endpoint);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize request body: " + e.getMessage());
        }
    }

    public Response putRequest(String endpoint, String body) {
        return request.body(body).put(endpoint);
    }

    public Response deleteRequest(String endpoint) {
        return request.delete(endpoint);
    }
}
