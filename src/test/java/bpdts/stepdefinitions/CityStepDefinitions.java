package bpdts.stepdefinitions;

import bpdts.pages.EncodeString;
import bpdts.pages.Environment;
import bpdts.pages.RandomCityGenerator;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CityStepDefinitions {
    private static final Logger LOG = LoggerFactory.getLogger(CityStepDefinitions.class);

    public String uri = Environment.getAppUrl() + "/city/%s/users";

    @Given("the city api status code is 200")
    public void assertStatusEquals200() throws UnsupportedEncodingException {
        String uri = Environment.getAppUrl() + "/city/" + URLEncoder.encode(RandomCityGenerator.randomCity(), "UTF-8") + "/users";
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


}
