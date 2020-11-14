package bpdts.stepdefinitions;

import bpdts.pages.EncodeString;
import bpdts.pages.Environment;
import bpdts.pages.RandomCityGenerator;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class InstructionsStepDefinitions {
    private static final Logger LOG = LoggerFactory.getLogger(InstructionsStepDefinitions.class);

    public String uri = Environment.getAppUrl() + "/instructions";

    @Given("the instructions api status code is 200")
    public void assertStatusEquals200() {
        LOG.debug("uri: " + uri);
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Given("the instructions api response is as expected")
    public void assertResponse() {
        LOG.debug("uri: " + uri);
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .body("todo",
                        equalTo("Create a short automated test for this API. Check that the data returned by the API is valid, and that ensure that each valid operation can be successfully called for each endpoint. Once you've built the tests, push the answer to Github or Gitlab, and send us a link. "));
    }

    @Given("the instructions api response matches the schema")
    public void assertSchema() {
        LOG.debug("uri: " + uri);
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/InstructionsSchema.json"));
    }


    @Given("^the instructions api content-type is application/json$")
    public void assertContentType(){
        LOG.debug("uri: " + uri);

        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .header("content-type", "application/json");
    }

}
