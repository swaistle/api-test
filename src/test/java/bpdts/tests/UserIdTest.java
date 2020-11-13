package bpdts.tests;

import bpdts.utility.Environment;
import bpdts.utility.RandomNumberGenerator;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserIdTest {
    private static final Logger LOG = LoggerFactory.getLogger(UserIdTest.class);

    public String uri = Environment.getAppUrl() + "/user/" + RandomNumberGenerator.randomNumber();

    @Test
    public void assertStatusEquals200() {
        LOG.debug("uri: " + uri);
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void assertSchema() {
        LOG.debug("uri: " + uri);
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("UserIdSchema.json"));
    }

}