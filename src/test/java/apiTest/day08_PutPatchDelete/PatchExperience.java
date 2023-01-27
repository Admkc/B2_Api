package apiTest.day08_PutPatchDelete;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class PatchExperience {


    @BeforeClass
    public void beforeClass(){

        baseURI="https://www.krafttechexlab.com/sw/api/v1";

    }
    @Test
    public void patchExperience(){

        String body="{\n" +
                "  \"job\": \"Junior Tester\",\n" +

                "  \"location\": \"USA\",\n" +
                "  \"fromdate\": \"YYYY-MM-DD\",\n" +
                "  \"todate\": \"YYYY-MM-DD\",\n" +
                "  \"current\": \"false\",\n" +
                "  \"description\": \"Description\"\n" +
                "}";

        Response response=given().accept(ContentType.JSON)
                .pathParam("id",247)
                .queryParam("token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdXQiOiJhRm0iLCJsaW5rIjoia3JhZnR0ZWNoZXhsYWIuY29tIiwidXNlcmlkIjoiMjk2Iiwic3RhcnQiOjE2NzQ4Mzg4MjEsImVuZHMiOjE2NzU0NDM2MjF9.MPadYHz64ox-joQzKX3npjASDejZEdyMr6DinRX2Bfby6rzWYI_rvawXvkAeyBrjuKiInSWnbfA7nJQDxm9QXA")
                .body(body)
                .when().log().all()
                .patch("/experience/updatepatch/{id}").prettyPeek();


    }


}
