package com.spartaglobal.RestasuredPostcodes;

import static org.junit.Assert.assertTrue;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

public class FootballTest {

    public final static String API_KEY = "909460929ff6419e8c7dff7bbdf39f9c";
    public final static String API_TOKEN = "X-Auth-Token";
    private static JsonPath respnse;


    @BeforeClass
    public static void setup(){
        baseURI = "https://api.football-data.org/v2/";
        basePath = "competitions/";


    }

    @Test
    public void testOne(){

        given()
                .header(API_TOKEN,API_KEY)
                .when()
                .get("SA/scorers")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("scorers[7].team.name", equalTo("Torino FC"));

    }

    @Test
    public void testTwo() {

            given()
                .header(API_TOKEN,API_KEY)
                .when()
                .get("SA/scorers")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("scorers[0].player.name", equalTo("Ciro Immobile"));
    }

    @Test
    public void testThree() {

        given()
                .header(API_TOKEN,API_KEY)
                .when()
                .get("SA/scorers")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("scorers[0].numberOfGoals", equalTo(14));
    }

    @Test
    public void testFour() {

        given()
                .header(API_TOKEN,API_KEY)
                .when()
                .get("SA/scorers")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("competition.area.name", equalTo("Italy"));
    }


    @Test
    public void testFive() {

        given()
                .header(API_TOKEN,API_KEY)
                .when()
                .get("PL/scorers")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("scorers[0].player.name", equalTo("Jamie Vardy"));
    }

    @Test
    public void testSix() {

        given()
                .header(API_TOKEN,API_KEY)
                .when()
                .get("PL/scorers")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("competition.area.name", equalTo("England"));
    }

}
