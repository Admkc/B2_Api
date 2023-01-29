package apiTest.day07_POSTRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

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
                "  \"school\": \"namik kemalOrt.\",\n" +
                "  \"degree\": \"takdir10\",\n" +
                "  \"study\": \"sayisal\",\n" +
                "  \"fromdate\": \"1991-07-03\",\n" +
                "  \"todate\": \"1995-08-02\",\n" +
                "  \"current\": \"false\",\n" +
                "  \"description\": \"good work\"\n" +
                "}";

        response=given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(education)
                .and()
                .queryParam("token",token)
                .when()
                .post("/education/add");

        assertEquals(response.statusCode(),200);
        response.prettyPrint();

    }
    @Test
    public void postNewUserAndVerify(){

        String name="efe08";
        String email="efe08@gmail.com";
        String password="1245698";
        String about="about me";
        String terms="12";

        Map<String ,Object> requestMap=new HashMap<>();

        requestMap.put("name",name);
        requestMap.put("email",email);
        requestMap.put("password",password);
        requestMap.put("about",about);
        requestMap.put("terms",terms);

        Response response=given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .body(requestMap)//serialization
                .when()
                .post("/allusers/register");


        assertEquals(response.statusCode(),200);


        String token=response.path("token");



        Map<String ,Object> educationBody=new HashMap<>();
        educationBody.put("school","Kraftecht");
        educationBody.put("degree","Bootcamp");
        educationBody.put("study","SDET");
        educationBody.put("fromdate","2000-01-22");
        educationBody.put("todate","2020-11-11");
        educationBody.put("current","false");
        educationBody.put("description","description11");

        response=given().accept(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(educationBody)
                .queryParam("token",token)
                .when()
                .post("education/add");

        response.prettyPrint();

        assertEquals(response.statusCode(),200);

        //verify body

        int id=response.path("id");

        response=given().accept(ContentType.JSON)
                .queryParam("token",token)
                .pathParam("id",id)
                .when()
                .get("/education/getbyid/{id}");

        response.prettyPrint();
        assertEquals(response.statusCode(),200);

        //verify with path

        System.out.println("id = " + id);


        assertEquals(response.path("school"),"Kraftech");

        //verify using hamcrest matcher

        given().accept(ContentType.JSON)
                .and()
                .queryParam("token",token)
                .pathParam("id",id)
                .when()
                .get("/education/getbyid/{id}")

                .then()
                .assertThat()
                .body("school",equalTo("Kraftech"),

                        "study",equalTo("SDET")).log().all();



    }

}
