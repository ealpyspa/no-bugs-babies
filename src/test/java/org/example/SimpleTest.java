package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SimpleTest {
    @BeforeAll
    public static void setUpTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/4d5f2dc88c804f2293c47fe964070201";

        // Принцип программирования: DRY = DO NOT REPEAT YOURSELF;
    }

    @Test
    public void userShouldBeAbleCreateStudent() {
        // given - when - then BDD
        StudentRequests.createStudent("{\n" +
                "  \"name\": \"Sasha Osipov\",\n" +
                "  \"grade\": 2\n" +
                "}");
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {

        // Принципы разработки API тестов
        // 1. Атомарность
        // 2. Тест сам себе готовит данные (то если надо удалить юзера, надо чтобы он был уже создан и именно в этом тесте, а не другом)

        // FAIL FIRST

        // ШАГ 1. Создание студента
       String id = StudentRequests.createStudent("{\n" +
                "  \"name\": \"Sasha Osipov\",\n" +
                "  \"grade\": 2\n" +
                "}");

        // ШАГ 2. Удаление студента
        StudentRequests.deleteStudent(id);

        // ШАГ 3. Проверить, что студент больше не существует
        given()
                .get("/student/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }
}
