package com.spartaglobal.RestasuredPostcodes;

import static org.junit.Assert.assertTrue;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SinglePostcodeTest
{

    private static Response singlePostcodeResponse;


    @BeforeClass
    public static void setup(){
        baseURI = "https://api.postcodes.io";
        basePath = "/postcodes/";
        singlePostcodeResponse = get("se120nb");
    }

    /**
     * Rigorous Test :-)
     */



    @Test
    public void postCodeRequestIsSuccessful()
    {
        get("se120nb")
                .then()
                .statusCode(200)
                .body("result.postcode", equalTo("SE12 0NB"));


    }
}
