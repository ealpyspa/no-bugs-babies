package org.example.api.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.example.api.models.Student;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentRequests {
    private static final Gson gson = new GsonBuilder().create();

    public static Student createStudent(Student student) {
        String studentJson = gson.toJson(student);

        return given()
                .contentType(ContentType.JSON)
                .body(studentJson)
                .when()
                .post("/student")
                .then()
                .assertThat().statusCode(201)
                .body("$", hasKey("_id"))
                .extract().as(Student.class, ObjectMapperType.GSON);
    }

    public static void deleteStudent(String id) {
        given()
                .delete("/student/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
