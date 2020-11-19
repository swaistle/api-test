package bpdts.stepdefinitions;

import bpdts.pages.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UsersStepDefinitions {
    private static final Logger LOG = LoggerFactory.getLogger(UsersStepDefinitions.class);

    public String uri = Environment.getAppUrl() + "/users";

    public Response response;

    @Given("I make a request for the users api")
    public void usersRequest() {
        LOG.debug("uri: " + uri);
        response = RestAssured.given()
                .when()
                .get(uri);
    }

    @Then("the users api status code is 200")
    public void assertStatusEquals200() {
        response.then()
                .assertThat()
                .statusCode(200);
    }

    @Then("the users api response matches the schema")
    public void assertSchema() {
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/UsersSchema.json"));
    }

    @Then("^the users api content-type is application/json$")
    public void assertContentType(){
        response.then()
                .assertThat()
                .header("content-type", "application/json");
    }

}
