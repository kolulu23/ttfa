package io.kolulu.ttfa;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;

@QuarkusTest
public class HelloWordTest {
    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/hello-world")
                .then()
                .statusCode(200)
                .body(containsStringIgnoringCase("World"));
    }

    @Test
    public void testGreetingEndpoint() {
        given()
                .pathParam("name", "Jesus Christ")
                .when().get("/hello-world/greetings/{name}")
                .then()
                .statusCode(200);
    }
}
