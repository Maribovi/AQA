package tests.java.rest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Patch {
    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .patch(BASE_URL + "/patch")
                .then()
                .extract().response();

        response.then().statusCode(200);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        response.then().body("data", equalTo(requestBody));
    }
}