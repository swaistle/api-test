package bpdts.stepdefinitions;

import bpdts.pages.Environment;
import bpdts.pages.RandomNumberGenerator;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserIdStepDefinitions {
    private static final Logger LOG = LoggerFactory.getLogger(UserIdStepDefinitions.class);

    public String uri = Environment.getAppUrl() + "/user/" + RandomNumberGenerator.randomNumber();

    @Given("the user id api status code is 200")
    public void assertStatusEquals200() {
        LOG.debug("uri: " + uri);
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Given("the user id api status code is 404")
    public void assertStatusEquals404() {
        String uri = Environment.getAppUrl() + "/user/" + 1001;
        LOG.debug("uri: " + uri);
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Given("the user id api response matches the schema")
    public void assertSchema() {
        for (int i = 1; i <= 1000; i++) {
            String uri = Environment.getAppUrl() + "/user/" + i;
            LOG.debug("uri: " + uri);
            RestAssured.given()
                    .when()
                    .get(uri)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body(matchesJsonSchemaInClasspath("schemas/UserIdSchema.json"));
        }
    }

}
