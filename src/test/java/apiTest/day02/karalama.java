package apiTest.day02;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

public class karalama {
    public static void main(String[] args) {
        String word = "ahmetBulutloöz";
        System.out.println("The letter before 'B' is: " + word.charAt(word.indexOf("B") - 1));
        System.out.println("The letter after 'B' is: " + word.charAt(word.indexOf("B") + 1));

        System.out.println("word.charAt(word.indexOf(\"l\")-1) = " + word.charAt(word.indexOf("l") - 1));
    }




    }
