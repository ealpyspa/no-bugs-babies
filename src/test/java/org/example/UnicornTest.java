package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.checkers.UnicornCheckers;
import org.example.api.models.Unicorn;
import org.example.api.requests.UnicornRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class UnicornTest {
    @BeforeAll
    public static void setUpTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/738e013d40984f6f83310daa88609e28";
    }

    @Test
    public void userShouldBeAbleToCreateUnicorn() {
        Unicorn unicorn = new Unicorn("White Lotus", "Purple");
        UnicornRequests.createUnicorn(unicorn.toJson());
    }

    @Test
    public void userShouldBeAbleToDeleteExistingUnicorn() {
        Unicorn unicorn = new Unicorn("White Lotus", "Purple");
        String id = UnicornRequests.createUnicorn(unicorn.toJson());

        UnicornRequests.deleteUnicorn(id);

        UnicornCheckers.checkThatUnicornDoesNotExistById(id);
    }

    @Test
    public void userShouldBeAbleToUpdateTailColorOfExistingUnicorn() {
        Unicorn unicorn = new Unicorn("White Lotus", "Purple");
        String id = UnicornRequests.createUnicorn(unicorn.toJson());

        unicorn.setTailColor("Yellow");
        UnicornRequests.updateUnicorn(id, unicorn.toJson());

        String actualTailColor = UnicornRequests.getUnicornField(id,"tailColor");

        assertThat(actualTailColor, equalTo("Yellow"));
    }
}
