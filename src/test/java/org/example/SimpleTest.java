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
        RestAssured.baseURI = "https://crudcrud.com/api/738e013d40984f6f83310daa88609e28";

        // Принцип программирования: DRY = DO NOT REPEAT YOURSELF;
    }

    @Test
    public void userShouldBeAbleCreateStudent() {
        // given - when - then BDD

        // сериализация из JSON в объект и наоборот

        Student student = Student.builder().name("Sasha Osipov").grade(2).build();
        StudentRequests.createStudent(student);
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {

        // Принципы разработки API тестов
        // 1. Атомарность
        // 2. Тест сам себе готовит данные (то если надо удалить юзера, надо чтобы он был уже создан и именно в этом тесте, а не другом)

        // FAIL FIRST

        // ШАГ 1. Создание студента
        Student student = Student.builder().name("Sasha Osipov").grade(2).build();
        Student createdStudent = StudentRequests.createStudent(student);

        // ШАГ 2. Удаление студента
        StudentRequests.deleteStudent(createdStudent.getId());

        // ШАГ 3. Проверить, что студент больше не существует
        given()
                .get("/student/" + createdStudent.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }
}
