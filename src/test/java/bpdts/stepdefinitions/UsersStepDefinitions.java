package bpdts.stepdefinitions;

import bpdts.pages.Environment;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UsersStepDefinitions {
    private static final Logger LOG = LoggerFactory.getLogger(UsersStepDefinitions.class);

    public String uri = Environment.getAppUrl() + "/users";

    @Given("the users api status code is 200")
    public void assertStatusEquals200() {
        LOG.debug("uri: " + uri);
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Given("the users api response matches the schema")
    public void assertSchema() {
        LOG.debug("uri: " + uri);
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/UsersSchema.json"));
    }

}
