package bpdts.tests;

import bpdts.utility.Environment;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UsersTest {

    public String uri = Environment.getAppUrl() + "/users";

    @Test
    public void assertStatusEquals200() {
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void assertSchema() {
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("UsersSchema.json"));
    }

}
