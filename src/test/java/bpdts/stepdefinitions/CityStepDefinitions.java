package bpdts.stepdefinitions;

import bpdts.pages.EncodeString;
import bpdts.pages.Environment;
import bpdts.pages.RandomCityGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CityStepDefinitions {
    private static final Logger LOG = LoggerFactory.getLogger(CityStepDefinitions.class);

    public String uri = Environment.getAppUrl() + "/city/%s/users";

    public Response response;
    private ValidatableResponse json;

    @Given("I make a request for a city")
    public void randomRequest(){
        String uri = Environment.getAppUrl() + "/city/" + EncodeString.encode(RandomCityGenerator.randomCity()) + "/users";
        LOG.debug("uri: " + uri);

        RequestSpecification request = RestAssured.given();

        response = request.get(uri);
    }

    @Given("^I make a request for the city (.*)$")
    public void specifiedRequest(String city){
        String formattedUri = String.format(uri, EncodeString.encode(city));
        LOG.debug("uri: " + formattedUri);

        response = RestAssured.given()
                .when()
                .get(formattedUri);
    }

    @Then("the city api status code is 200")
    public void assertStatusEquals200() {
        response.then().assertThat().statusCode(200);
    }

    @Then("the response matches the schema")
    public void matchesSchema() {
        response.then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/CitySchema.json"));
    }

    @Given("^the response content-type is application/json$")
    public void assertContentType(){
        response.then().assertThat()
                .header("content-type", "application/json");
    }

}
