package apiTest.day07_POSTRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostRequestDemo {

    @BeforeClass
    public void beforeClass(){

        baseURI="https://www.krafttechexlab.com/sw/api/v1";

    }
    @Test
    public void postNewUser(){

        String jsonBody="{\n" +
                "  \"name\": \"efe03\",\n" +
                "  \"email\": \"efe03@krafttechexlab.com\",\n" +
                "  \"password\": \"4003\",\n" +
                "  \"about\": \"sekercik\",\n" +
                "  \"terms\": \"5\"\n" +
                "}";

        Response response=given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("/allusers/register");


       assertEquals(response.statusCode(),200);

        response.prettyPrint();

        assertTrue(response.body().asString().contains("token"));

    }
    @Test
    public void postNewUser2(){
        Map<String,Object> requestMap=new HashMap<>();

        requestMap.put("name","efe04");
        requestMap.put("email","efe04@krafttechexlab.com");
        requestMap.put("password","4040");
        requestMap.put("about","from Urfa");
        requestMap.put("terms","12");

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .body(requestMap)
                .when()
                .get("/allusers/register");

        assertEquals(response.statusCode(),200);

        assertTrue(response.body().asString().contains("token"));

    }
    @Test
    public void postNewUser3(){

        NewUserInfo newUserInfo=new NewUserInfo();

        newUserInfo.setName("efe05");
        newUserInfo.setEmail("efe05@krafttechexlab.com");
        newUserInfo.setPassword("45896");
        newUserInfo.setAbout("About Me");
        newUserInfo.setTerms("4");

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .body(newUserInfo)
                .when()
                .get("/allusers/register");

        assertEquals(response.statusCode(),200);

        assertTrue(response.body().asString().contains("token"));

    }
    @Test
    public void postNewUser4(){
        NewUserInfo newUserInfo= new NewUserInfo("efecik06","efe06@krafttechexlab.com",
                "4536","About Me","11");

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .body(newUserInfo)
                .when()
                .get("/allusers/register");

        assertEquals(response.statusCode(),200);

        assertTrue(response.body().asString().contains("token"));



    }




}
