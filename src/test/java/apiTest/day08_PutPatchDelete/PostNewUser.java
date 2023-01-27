package apiTest.day08_PutPatchDelete;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


import static io.restassured.RestAssured.baseURI;

public class PostNewUser {


    @BeforeClass
    public void beforeClass(){

        baseURI="https://www.krafttechexlab.com/sw/api/v1";

    }
    @Test
    public void newUser(){
        String jsonBody="{\n" +
                "  \"name\": \"efe11\",\n" +
                "  \"email\": \"efe11@krafttechexlab.com\",\n" +
                "  \"password\": \"40023\",\n" +
                "  \"about\": \"sekercik11\",\n" +
                "  \"terms\": \"4\"\n" +
                "}";

        Response response=given().accept(ContentType.JSON)
                .body(jsonBody)
                .when().log().all()
                .post("allusers/register").prettyPeek();

        String token=response.path("token");
        System.out.println("token = " + token);

     //   token = eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdXQiOiJhRm0iLCJsaW5rIjoia3JhZnR0ZWNoZXhsYWIuY29tIiwidXNlcmlkIjoiMjk2Iiwic3RhcnQiOjE2NzQ4Mzg4MjEsImVuZHMiOjE2NzU0NDM2MjF9.MPadYHz64ox-joQzKX3npjASDejZEdyMr6DinRX2Bfby6rzWYI_rvawXvkAeyBrjuKiInSWnbfA7nJQDxm9QXA


    }
}
