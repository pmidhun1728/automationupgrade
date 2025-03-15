package com.upgrade.tests.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.POJO;

public class APITest extends BaseTestAPI {
   BaseTestAPI baseTestAPI;
    POJO pojo;

    @Test
    public void getCall(){
        Response response = getRequest("");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void postCall() throws JsonProcessingException {

        POJO requestPayload = new POJO(1, 201, 2, "InProgress", true);


        Response response = postRequest("", requestPayload);

        JsonPath jsonPath= response.jsonPath();
        int getId = jsonPath.getInt("id");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getId, 1);

        Response getResponse = getRequest("1");
        int id = jsonPath.getInt("id");

        softAssert.assertEquals(id, 1);
    }
}
