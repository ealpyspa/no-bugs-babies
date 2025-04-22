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
        RestAssured.baseURI = "https://crudcrud.com/api/0b9babdd98cd472ab4b192587e90596f";
    }

    @Test
    public void userShouldBeAbleToCreateUnicorn() {
        Unicorn unicorn = Unicorn.builder().name("White Lotus").tailColor("Purple").build();
        UnicornRequests.createUnicorn(unicorn);
    }

    @Test
    public void userShouldBeAbleToDeleteExistingUnicorn() {
        Unicorn unicorn = Unicorn.builder().name("White Lotus").tailColor("Purple").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        UnicornRequests.deleteUnicorn(createdUnicorn.getId());

        UnicornCheckers.checkThatUnicornDoesNotExistById(createdUnicorn.getId());
    }

    @Test
    public void userShouldBeAbleToUpdateTailColorOfExistingUnicorn() {
        Unicorn unicorn = Unicorn.builder().name("White Lotus").tailColor("Purple").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        Unicorn updatedData = Unicorn.builder().name(createdUnicorn.getName()).tailColor("Yellow").build();

        UnicornRequests.updateUnicorn(createdUnicorn.getId(), updatedData);

        Unicorn updatedUnicorn = UnicornRequests.getUnicornById(createdUnicorn.getId());

        assertThat(updatedUnicorn.getTailColor(), equalTo("Yellow"));
    }
}
