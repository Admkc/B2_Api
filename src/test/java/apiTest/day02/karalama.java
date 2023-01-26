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
    @BeforeClass
    public void beforeClass(){

        baseURI="https://www.krafttechexlab.com/sw/api/v1";

    }
    @Test
    public void test(){
        /**
         * end point => /allusers/alluser -> GET All User
         * page size : 50
         * page : 2
         * The company in the 8. user's experience part
         * verify this informat,on
         * 1.company -> Ghan IT Com
         * 2.company -> GHAN II IT BV
         */
        Response response = given().accept(ContentType.JSON)
                .queryParam("pagesize", 50)
                .queryParam("page", 2)
                .when().get("/allusers/alluser");

        Assert.assertEquals(response.statusCode(),200);

        List<Map<String ,Object>> alluser=response.body().as(List.class);

        System.out.println("alluser = " + alluser);

        List<Map<String ,Object>> experUser= (List<Map<String, Object>>) alluser.get(7).get("experience");

        System.out.println("experUser = " + experUser);

        String com1= (String) experUser.get(0).get("company");
        Assert.assertEquals(com1,"Ghan IT Com");

        String com2= (String) experUser.get(1).get("company");

        Assert.assertEquals(com2,"GHAN II IT BV");



    }




    }
