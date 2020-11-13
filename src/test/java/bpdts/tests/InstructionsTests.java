package bpdts.tests;

import bpdts.utility.Environment;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class InstructionsTests {

    public String uri = Environment.getAppUrl() + "/instructions";

    @Test
    public void assertStatusEquals200() throws IOException {
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test public void assertResponse() throws IOException {
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .body("todo",
                        equalTo("Create a short automated test for this API. Check that the data returned by the API is valid, and that ensure that each valid operation can be successfully called for each endpoint. Once you've built the tests, push the answer to Github or Gitlab, and send us a link. "));
    }

    @Test
    public void assertSchema() {
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("InstructionsSchema.json"));
    }

}
