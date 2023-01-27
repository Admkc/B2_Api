package apiTest.day07_POSTREquest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PostSaveEducation {


    @BeforeClass
    public void beforeClass(){

        baseURI="https://www.krafttechexlab.com/sw/api/v1";

    }

    @Test
    public void postNewUser4(){
        NewUserInfo newUserInfo= new NewUserInfo("efecik07","efe07@krafttechexlab.com",
                "78536","About Me","15");

        Response response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .body(newUserInfo)
                .when()
                .get("/allusers/register");

        assertEquals(response.statusCode(),200);

        String token=response.path("token");

        String education="{\n" +
                "  \"school\": \"namik kemal\",\n" +
                "  \"degree\": \"takdir\",\n" +
                "  \"study\": \"sayisal\",\n" +
                "  \"fromdate\": \"1991-07-03\",\n" +
                "  \"todate\": \"1995-08-02\",\n" +
                "  \"current\": \"false\",\n" +
                "  \"description\": \"good work\"\n" +
                "}";








    }

}
