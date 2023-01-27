package apiTest.day08_PutPatchDelete;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PutExperience {

    @BeforeClass
    public void beforeClass(){

        baseURI="https://www.krafttechexlab.com/sw/api/v1";

    }
    @Test
    public void updateExperience(){


        String body="{\n" +
                "  \"job\": \"Junior new Developer4\",\n" +
                "  \"company\": \"Euro Techex\",\n" +
                "  \"location\": \"Germany\",\n" +
                "  \"fromdate\": \"2022-05-01\",\n" +
                "  \"todate\": \"2021-12-02\",\n" +
                "  \"current\": \"false\",\n" +
                "  \"description\": \"good job\"\n" +
                "}";

        Response response=given().accept(ContentType.JSON)
                .queryParam("token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdXQiOiJhRm0iLCJsaW5rIjoia3JhZnR0ZWNoZXhsYWIuY29tIiwidXNlcmlkIjoiMjk2Iiwic3RhcnQiOjE2NzQ4Mzg4MjEsImVuZHMiOjE2NzU0NDM2MjF9.MPadYHz64ox-joQzKX3npjASDejZEdyMr6DinRX2Bfby6rzWYI_rvawXvkAeyBrjuKiInSWnbfA7nJQDxm9QXA")
                .queryParam("id",247)
                .body(body)
                .when().log().all()
                .put("/experience/updateput").prettyPeek();

    }


}
