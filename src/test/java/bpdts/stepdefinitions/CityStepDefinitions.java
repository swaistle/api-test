package bpdts.stepdefinitions;

import bpdts.pages.EncodeString;
import bpdts.pages.Environment;
import bpdts.pages.RandomCityGenerator;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CityStepDefinitions {
    private static final Logger LOG = LoggerFactory.getLogger(CityStepDefinitions.class);

    public String uri = Environment.getAppUrl() + "/city/%s/users";

    @Given("the city api status code is 200")
    public void assertStatusEquals200() {
        String uri = Environment.getAppUrl() + "/city/" + EncodeString.encode(RandomCityGenerator.randomCity()) + "/users";
        LOG.debug("uri: " + uri);

        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Given("^user(?:s)? from (.*) matches the schema$")
    public void assertSchema(String city) {
        String formattedUri = String.format(uri, EncodeString.encode(city));
        LOG.debug("uri: " + formattedUri);

        RestAssured.given()
                .when()
                .get(formattedUri)
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/CitySchema.json"));

    }

    @Given("^the city api content-type is application/json$")
    public void assertContentType(){
        String uri = Environment.getAppUrl() + "/city/" + EncodeString.encode(RandomCityGenerator.randomCity()) + "/users";
        LOG.debug("uri: " + uri);

        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .header("content-type", "application/json");
    }

}
