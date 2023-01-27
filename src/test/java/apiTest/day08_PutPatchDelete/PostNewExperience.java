package apiTest.day08_PutPatchDelete;


import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.baseURI;

public class PostNewExperience {


    @BeforeClass
    public void beforeClass(){

        baseURI="https://www.krafttechexlab.com/sw/api/v1";

    }
    @Test
    public void newExperience(){

        String body="{\n" +
                "  \"job\": \"Junior new Developer4\",\n" +
                "  \"company\": \"Kraft new2 Techex\",\n" +
                "  \"location\": \"USA\",\n" +
                "  \"fromdate\": \"2022-05-01\",\n" +
                "  \"todate\": \"2021-12-02\",\n" +
                "  \"current\": \"false\",\n" +
                "  \"description\": \"Description11\"\n" +
                "}";
        Response response=given().accept(ContentType.JSON)
                .queryParam("token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdXQiOiJhRm0iLCJsaW5rIjoia3JhZnR0ZWNoZXhsYWIuY29tIiwidXNlcmlkIjoiMjk2Iiwic3RhcnQiOjE2NzQ4Mzg4MjEsImVuZHMiOjE2NzU0NDM2MjF9.MPadYHz64ox-joQzKX3npjASDejZEdyMr6DinRX2Bfby6rzWYI_rvawXvkAeyBrjuKiInSWnbfA7nJQDxm9QXA")
                .body(body)
                .when().log().all()
                .post("/experience/add").prettyPeek();

        // "id": 247,

    }
}
