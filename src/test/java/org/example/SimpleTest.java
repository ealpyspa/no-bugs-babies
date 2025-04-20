package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.api.models.Student;
import org.example.api.requests.StudentRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SimpleTest {
    @BeforeAll
    public static void setUpTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/576ca1fe412444c69d949b98f288ba9d";

        // Принцип программирования: DRY = DO NOT REPEAT YOURSELF;
    }

    @Test
    public void userShouldBeAbleCreateStudent() {
        // given - when - then BDD

        // сериализация из JSON в объект и наоборот

        Student student = new Student("Sasha Osipov", 2);

        StudentRequests.createStudent(student.toJson());
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {

        // Принципы разработки API тестов
        // 1. Атомарность
        // 2. Тест сам себе готовит данные (то если надо удалить юзера, надо чтобы он был уже создан и именно в этом тесте, а не другом)

        // FAIL FIRST

        // ШАГ 1. Создание студента
        Student student = new Student("Sasha Osipov", 2);
        String id = StudentRequests.createStudent(student.toJson());

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
