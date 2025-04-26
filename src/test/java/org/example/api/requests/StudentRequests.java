package org.example.api.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.example.api.models.Student;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentRequests {
    private static final ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static Student createStudent(Student student) {
        String studentJson = null;

        try {
            studentJson = objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return given()
                .contentType(ContentType.JSON)
                .body(studentJson)
                .when()
                .post("/student")
                .then()
                .assertThat().statusCode(201)
                .body("$", hasKey("_id"))
                .extract().as(Student.class, ObjectMapperType.JACKSON_2);
    }

    public static void deleteStudent(String id) {
        given()
                .delete("/student/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
