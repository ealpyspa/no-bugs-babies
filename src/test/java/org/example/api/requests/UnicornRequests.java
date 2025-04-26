package org.example.api.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.apache.http.HttpStatus;
import org.example.api.models.Unicorn;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    private static final ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

    private static String toJson(Unicorn unicorn) {
        try {
            return objectMapper.writeValueAsString(unicorn);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Unicorn createUnicorn(Unicorn unicorn) {
        return given()
                .contentType(ContentType.JSON)
                .body(toJson(unicorn))
                .when()
                .post("/unicorn")
                .then()
                .assertThat().statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract().as(Unicorn.class, ObjectMapperType.JACKSON_2);
    }

    public static void deleteUnicorn(String id) {
        given()
                .delete("/unicorn/" + id)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    public static void updateUnicorn(String id, Unicorn unicorn) {
        given()
                .contentType(ContentType.JSON)
                .body(toJson(unicorn))
                .when()
                .put("/unicorn/" + id)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    public static Unicorn getUnicornById(String id) {
        return given()
                .get("/unicorn/" + id)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(Unicorn.class);
    }
}
