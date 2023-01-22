package apiTest.day02;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class karalama {

   @BeforeClass
    public  void beforeTest(){

       baseURI="https://www.krafttechexlab.com/sw/api/v1";

   }

   @Test
    public void test(){
       Response response=given().accept(ContentType.JSON)
               .when().get("https://demoqa.com/BookStore/v1/Books");



       Assert.assertEquals(response.statusCode(),200);
       Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");

       String isbn=response.body().path("books.isbn[0]");

       String publisher=response.path("books.publisher[0]");

       Assert.assertEquals(isbn,"9781449325862");
       Assert.assertEquals(publisher,"O'Reilly Media");

       String descp=response.path("books.description[0]");

       Assert.assertEquals(descp,"This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp");

       System.out.println("descp = " + descp);


   }
    }
