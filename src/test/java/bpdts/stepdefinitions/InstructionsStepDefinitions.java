package bpdts.stepdefinitions;

import bpdts.pages.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class InstructionsStepDefinitions {
    private static final Logger LOG = LoggerFactory.getLogger(InstructionsStepDefinitions.class);

    public String uri = Environment.getAppUrl() + "/instructions";

    public Response response;

    @Given("I make a request for the instructions api")
    public void instructionsRequest() {
        LOG.debug("uri: " + uri);
        response = RestAssured.given()
                .when()
                .get(uri);
    }

    @Then("the instructions api status code is 200")
    public void assertStatusEquals200() {
        response.then()
                .assertThat()
                .statusCode(200);
    }

    @Then("the instructions api response is as expected")
    public void assertResponse() {
        response.then()
                .assertThat()
                .body("todo",
                        equalTo("Create a short automated test for this API. Check that the data returned by the API is valid, and that ensure that each valid operation can be successfully called for each endpoint. Once you've built the tests, push the answer to Github or Gitlab, and send us a link. "));
    }

    @Then("the instructions api response matches the schema")
    public void assertSchema() {
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/InstructionsSchema.json"));
    }


    @Then("^the instructions api content-type is application/json$")
    public void assertContentType(){
        response.then()
                .assertThat()
                .header("content-type", "application/json");
    }

}
