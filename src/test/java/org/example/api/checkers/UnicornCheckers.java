package org.example.api.checkers;

import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class UnicornCheckers {
    public static void checkThatUnicornDoesNotExistById(String id) {
        given()
                .get("/unicorn/" + id)
                .then()
                .assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
