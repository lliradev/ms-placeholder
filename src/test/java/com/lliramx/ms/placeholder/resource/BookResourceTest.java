package com.lliramx.ms.placeholder.resource;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {

    @Test
    void should_get_all_books() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
            .when()
            .get("/api/books")
            .then()
            .statusCode(200)
            .body("size()", is(5));
    }

    @Test
    void should_count_all_books() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
            .when()
            .get("/api/books/count")
            .then()
            .statusCode(200)
            .body(is("5"));
    }

    @Test
    void should_get_a_book() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
            .pathParam("id", 1)
            .when()
            .get("/api/books/{id}")
            .then()
            .statusCode(200)
            .body("title", is("Java 1.8"))
            .body("id", is(1))
            .body("author", is("Antonio 1"));
    }

}
