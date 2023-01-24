package apiTest.day02;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class karalama {
    public static void main(String[] args) {


        String word = "ahmetBulutloöz";
        System.out.println("The letter before 'B' is: " + word.charAt(word.indexOf("B") - 1));
        System.out.println("The letter after 'B' is: " + word.charAt(word.indexOf("B") + 1));

        System.out.println("word.charAt(word.indexOf(\"l\")-1) = " + word.charAt(word.indexOf("l") - 1));
    }
    @BeforeClass
    public void beforeClass(){

        baseURI="https://www.krafttechexlab.com/sw/api/v1";

    }
    @Test
    public void test(){

        Response response=given().accept(ContentType.JSON)
                .queryParam("pagesize",50)
                .queryParam("page",1)
                .when().get("/allusers/alluser");

        Assert.assertEquals(response.statusCode(),200);

        List<Map<String ,Object>> alluser=response.body().as(List.class);

        System.out.println("alluser = " + alluser);

        System.out.println("alluser.get(1).get(\"name\") = " + alluser.get(1).get("name"));
        String nam= (String) alluser.get(1).get("name");
        Assert.assertEquals(nam,"isa akyuz");

        System.out.println("alluser.get(0).get(\"skills\") = " + alluser.get(0).get("skills"));

        List<String > skl= (List<String>) alluser.get(0).get("skills");

        Assert.assertEquals(skl.get(0),"PHP");

        List<Map<String ,Object>> expelistMap= (List<Map<String, Object>>) alluser.get(0).get("experience");

        System.out.println("expelistMap = " + expelistMap);

        System.out.println("expelistMap.get(1).get(\"job\") = " + expelistMap.get(1).get("job"));


    }




    }
