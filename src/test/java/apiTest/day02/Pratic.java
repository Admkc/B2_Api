package apiTest.day02;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Pratic {

    /**
     * https://jsonplaceholder.typicode.com/posts/44 bir get request yolladıgımızda dönen response ın

     status codunun 200
     content type nin Json
     ve response body sinde bulunan user id nin 5,
     ve response body sinde bulunan title ın "optio dolar monestio sit"
      oldugunu test edin
     */

    @Test
    public void test1(){

        String url="https://jsonplaceholder.typicode.com/posts/44";

        Response response= RestAssured.given().when().get(url);

        System.out.println("response.statusCode() = " + response.statusCode());


        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        Assert.assertEquals(response.statusCode(),200);

        System.out.println("response.contentType() = " + response.contentType());

        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");

        JsonPath actbody=response.jsonPath();

        Assert.assertEquals(actbody,"userId");


    }






}
