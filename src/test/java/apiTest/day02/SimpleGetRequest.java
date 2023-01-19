package apiTest.day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetRequest {

    String petStoreURL="https://petstore.swagger.io/v2";

    @Test

    public void Test1(){

        Response response = RestAssured.get(petStoreURL+"/store/inventory");

        //print status code
        System.out.println("response.statusCode() = " + response.statusCode());

        //print body
        System.out.println("response.prettyPrint() = " + response.prettyPrint());
    }

    @Test

    public void Test2(){

        Response response = RestAssured.given().accept(ContentType.JSON).when().get(petStoreURL + "/store/inventory");

        System.out.println("response.statusCode() = " + response.statusCode());

        Assert.assertEquals(response.statusCode(),200);

        Assert.assertEquals(response.contentType(),"application/json");

    }
    @Test
    public void Test3(){

        //verify test case with using RestAssured Library

        RestAssured.given().accept(ContentType.JSON)
                .when().get(petStoreURL+"/store/inventory")
                .then()
                .assertThat().statusCode(200)
                .and()
                .contentType("application/json");

    }
    @Test
    public void test4(){
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get(petStoreURL + "/store/inventory");
        Assert.assertEquals(response.statusCode(),200);

        System.out.println("response.asString() = " + response.asString());

        Assert.assertTrue(response.body().asString().contains("sold"));


    }

}
