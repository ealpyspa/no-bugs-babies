package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.checkers.UnicornCheckers;
import org.example.api.requests.UnicornRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class UnicornTest {
    @BeforeAll
    public static void setUpTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/66595698398c4fa8913783fecb353397";
    }

    @Test
    public void userShouldBeAbleToCreateUnicorn() {
        UnicornRequests.createUnicorn("""
                {
                "name": "White Lotus",
                 "tail color": "Purple"
                }
                """);
    }

    @Test
    public void userShouldBeAbleToDeleteExistingUnicorn() {
        String id = UnicornRequests.createUnicorn("""
                {
                "name": "White Lotus",
                 "tail color": "Purple"
                }
                """);

        UnicornRequests.deleteUnicorn(id);

        UnicornCheckers.checkThatUnicornDoesNotExistById(id);
    }

    @Test
    public void userShouldBeAbleToUpdateTailColorOfExistingUnicorn() {
        String id = UnicornRequests.createUnicorn("""
                {
                "name": "White Lotus",
                 "tail color": "Purple"
                }
                """);

        UnicornRequests.updateUnicorn(id, """
                {
                "name": "White Lotus",
                 "tail color": "Yellow"
                }
                """);

        String actualTailColor = UnicornRequests.getUnicornField(id,"tail color");

        assertThat(actualTailColor, equalTo("Yellow"));
    }
}
