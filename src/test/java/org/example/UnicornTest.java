package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.checkers.UnicornCheckers;
import org.example.api.models.Unicorn;
import org.example.api.requests.UnicornRequests;
import org.example.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class UnicornTest {
    @BeforeAll
    public static void setUpTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/652c427d55ca43a095611fa14ec504d3";
    }

    @Test
    public void userShouldBeAbleToCreateUnicorn() {
        Unicorn unicorn = Unicorn.builder().name(RandomData.randomString()).tailColor(RandomData.randomString()).build();
        UnicornRequests.createUnicorn(unicorn);
    }

    @Test
    public void userShouldBeAbleToDeleteExistingUnicorn() {
        Unicorn unicorn = Unicorn.builder().name(RandomData.randomString()).tailColor(RandomData.randomString()).build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        UnicornRequests.deleteUnicorn(createdUnicorn.getId());

        UnicornCheckers.checkThatUnicornDoesNotExistById(createdUnicorn.getId());
    }

    @Test
    public void userShouldBeAbleToUpdateTailColorOfExistingUnicorn() {
        Unicorn unicorn = Unicorn.builder().name(RandomData.randomString()).tailColor(RandomData.randomString()).build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        Unicorn updatedData = Unicorn.builder().name(createdUnicorn.getName()).tailColor(RandomData.randomString()).build();

        UnicornRequests.updateUnicorn(createdUnicorn.getId(), updatedData);

        Unicorn updatedUnicorn = UnicornRequests.getUnicornById(createdUnicorn.getId());

        assertThat(updatedUnicorn.getTailColor(), equalTo(updatedData.getTailColor()));
    }
}
