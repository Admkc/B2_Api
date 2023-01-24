package apiTest.day02;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;

public class Pratic {

    @BeforeClass
    public void beforeClass(){

        baseURI="https://www.krafttechexlab.com/sw/api/v1";

    }


    /**
     * https://jsonplaceholder.typicode.com/posts/44 bir get request yolladıgımızda dönen response ın

     status codunun 200
     content type nin Json
     ve response body sinde bulunan user id nin 5,
     ve response body sinde bulunan title ın "optio dolor molestias sit"
      oldugunu test edin
     */
    @Test
    public void test1(){
        String url="https://jsonplaceholder.typicode.com/posts/44";
        Response response=given().when().get(url);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");

        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();

       int idjson=jsonPath.getInt("userId");
        System.out.println("userid = " + idjson);

        Assert.assertEquals(idjson,5);

        String titlejson=jsonPath.getString("title");

        System.out.println("titlejson = " + titlejson);

        Assert.assertEquals(titlejson,"optio dolor molestias sit");
    }

   /** TASK
    Given accept type is json
    And Path param user id is 111
    When user sends a GET request to /allusers/getbyid/{id}
    Then the status Code should be 200
    And Content type json should be "application/json; charset=UTF-8"
    And user's company should be "GHAN Software"
    And user's id should be 111
    And SQL should be the one of the user's skills
    And user's education should be ODTU, Delft University
    And user's email should be thomas@test.com
    */
   @Test
    public void test2(){

       Response response=given().accept(ContentType.JSON)
               .pathParam("id",111)
               .when()
               .get("/allusers/getbyid/{id}");

       response.prettyPrint();

       System.out.println("response.statusCode() = " + response.statusCode());
       System.out.println("response.contentType() = " + response.contentType());
       Assert.assertEquals(response.statusCode(),200);
       Assert.assertEquals(response.contentType(),"application/json; charset=UTF-8");

       JsonPath jsonPath=response.jsonPath();

       String company=jsonPath.getString("company[0]");
       System.out.println("company = " + company);
       Assert.assertEquals(company,"GHAN Software");

       int id=jsonPath.getInt("id[0]");
       System.out.println("id = " + id);
       Assert.assertEquals(id,111);


       String skill=jsonPath.getString("skills");
       System.out.println("skill = " + skill);
       //  String lastSql=jsonPath.getString("skills[-1]");
       Assert.assertTrue(skill.contains("SQL"));

       List<String > skill2=jsonPath.getList("skills[0]");
       System.out.println("skill2 = " + skill2);
       System.out.println("skill2.get(4) = " + skill2.get(4));


       String email=jsonPath.getString("email[0]");
       System.out.println("email = " + email);
       Assert.assertEquals(email,"thomas@test.com");

       String education=jsonPath.getString("education[0][0]");
       System.out.println("education = " + education);

       Assert.assertTrue(education.contains("ODTU"));

       String education2=jsonPath.getString("education[0][1]");
       System.out.println("education2 = " + education2);
       Assert.assertTrue(education2.contains("Delft University"));

       Map<String,Object > educate3=jsonPath.getMap("education[0][0]");

       System.out.println("educate3.get(\"scholl\") = " + educate3.get("school"));

       Map<String,Object > educate4=jsonPath.getMap("education[0][1]");

       System.out.println("educate4.get(\"school\") = " + educate4.get("school"));

       System.out.println("educate3.get(\"description\") = " + educate3.get("description"));

       System.out.println("educate4.get(\"id\") = " + educate4.get("id"));

       Map<String,Object> exp=jsonPath.getMap("experience[0][2]");

       System.out.println("exp.get(\"location\") = " + exp.get("location"));

       String location3=jsonPath.getString("experience.location[0]") ;

       System.out.println("location3 = " + location3);

       List<String> location4=jsonPath.getList("experience.location[0]");

       System.out.println("location4.get(2) = " + location4.get(2));


   }


}
