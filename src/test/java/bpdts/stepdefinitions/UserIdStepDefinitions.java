package bpdts.stepdefinitions;

import bpdts.pages.Environment;
import bpdts.pages.RandomNumberGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
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

    public Response response;

    @Given("I make a valid request for the user id api")
    public void randomUserIdRequest() {
        response = RestAssured.given()
                .when()
                .get(uri);
    }

    @Given("I make an invalid request for the user id api")
    public void invalidUserIdRequest() {
        String uri = Environment.getAppUrl() + "/user/" + 1001;
        LOG.debug("uri: " + uri);
        response = RestAssured.given()
                .when()
                .get(uri);
    }

    @Given("^I make a request for the user (.*)$")
    public void specificUserIdRequest(String userId) {
        String uri = Environment.getAppUrl() + "/user/" + userId;
        LOG.debug("uri: " + uri);
        response = RestAssured.given()
                .when()
                .get(uri);
    }



    @Then("the user id api status code is 200")
    public void assertStatusEquals200() {
        LOG.debug("uri: " + uri);
        response.then()
                .assertThat()
                .statusCode(200);
    }

    @Then("the user id api status code is 404")
    public void assertStatusEquals404() {
        response.then()
                .assertThat()
                .statusCode(404);
    }

    @Then("the user id api response matches the schema")
    public void assertSchema() {
        response.then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/UserIdSchema.json"));
    }

    @Then("^the user id api content-type is application/json$")
    public void assertContentType(){
        response.then()
                .assertThat()
                .header("content-type", "application/json");
    }

}
