package apiTest.day03;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserGetRequest {

    String exlabURL="https://www.krafttechexlab.com/sw/api/v1";
    /**
     * get all users
     */

    @Test
    public void test1(){

        Response response= given().accept(ContentType.JSON)
                .queryParam("pagesize",50)
                .queryParam("page",1)
                .and().when()
                .get(exlabURL+"/allusers/alluser");

        System.out.println("response.statusCode() = " + response.statusCode());

        response.prettyPrint();
    }
    @Test
    public void test2(){
        /**
   TASK
        When user sends a GET request to /allusers/getbyid/111
        Then Status code should be 200
        And content type should be application/json; charset=UTF-8
        And json body should contain Thomas Eduson

    */
        Response response=given().accept(ContentType.JSON)
                .pathParam("id",111)
                .when()
                .get(exlabURL+"/allusers/getbyid/{id}");

        //response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=UTF-8");

        //verify the header
        Assert.assertEquals(response.header("Content-Length"),"636");
        Assert.assertEquals(response.header("Content-Type"),"application/json; charset=UTF-8");

        //only date (degisecegi icin)
        Assert.assertTrue(response.headers().hasHeaderWithName("Date"));

        //verify the body
        Assert.assertTrue(response.body().asString().contains("Thomas Eduson"));
    }


}