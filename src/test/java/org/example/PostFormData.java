package tests.java.rest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostFormData {
    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testPostmanEcho() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post(BASE_URL + "/post")
                .then()
                .log().all()
                .extract()
                .response();

        response.then().statusCode(200);

        response.then().body("form.foo1", equalTo("bar1"));
        response.then().body("form.foo2", equalTo("bar2"));
    }
}