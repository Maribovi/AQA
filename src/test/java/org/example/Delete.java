package tests.java.rest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Delete {
    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testDeleteRequest() {
        Response response = given()
                .header("Content-Type", "text/plain")
                .when()
                .delete(BASE_URL + "/delete");

        response.then().statusCode(200);

        response.then()
                .body("url", equalTo(BASE_URL + "/delete"));
    }
}