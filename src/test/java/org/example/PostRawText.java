package tests.java.rest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostRawText {
    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testPostRequest() {
        Response response = given()
                .contentType("application/json")
                .body("{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}")
                .when()
                .post(BASE_URL + "/post");

        assertEquals(200, response.getStatusCode());

        response.then()
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }
}