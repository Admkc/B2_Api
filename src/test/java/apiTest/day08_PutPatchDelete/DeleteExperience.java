package apiTest.day08_PutPatchDelete;


import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DeleteExperience {

    @BeforeClass
    public void beforeClass(){

        baseURI="https://www.krafttechexlab.com/sw/api/v1";

    }

    @Test
    public void deleteExperience(){

        Response response=given().accept(ContentType.JSON)
                .pathParam("id",247)
                .queryParam("token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdXQiOiJhRm0iLCJsaW5rIjoia3JhZnR0ZWNoZXhsYWIuY29tIiwidXNlcmlkIjoiMjk2Iiwic3RhcnQiOjE2NzQ4Mzg4MjEsImVuZHMiOjE2NzU0NDM2MjF9.MPadYHz64ox-joQzKX3npjASDejZEdyMr6DinRX2Bfby6rzWYI_rvawXvkAeyBrjuKiInSWnbfA7nJQDxm9QXA")
                .when().log().all()
                .delete("experience/delete/{id}").prettyPeek();
    }

}
