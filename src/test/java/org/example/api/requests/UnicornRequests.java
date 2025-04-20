package org.example.api.requests;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    public static String createUnicorn(String body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/unicorn")
                .then()
                .assertThat().statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract()
                .path("_id");
    }

    public static void deleteUnicorn(String id) {
        given()
                .delete("/unicorn/" + id)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    public static void updateUnicorn(String id, String body) {
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("/unicorn/" + id)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .body("$", hasKey("tail color"));
    }

    public static String getUnicornField(String id, String field) {
        return given()
                .get("/unicorn/" + id)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .body("$", hasKey(field))
                .extract().path(field);
    }
}
