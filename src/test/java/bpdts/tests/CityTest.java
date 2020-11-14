package bpdts.tests;

import bpdts.utility.Environment;
import bpdts.utility.RandomCityGenerator;
import io.restassured.RestAssured;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CityTest {
    private static final Logger LOG = LoggerFactory.getLogger(CityTest.class);

    public String uri = Environment.getAppUrl() + "/city/%s/users";

    @Test
    public void assertStatusEquals200() {
        String uri = Environment.getAppUrl() + "/city/" + RandomCityGenerator.randomCity() + "/users";
        LOG.debug("uri: " + uri);
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void assertSchemaOneResult() {
        String formattedUri = String.format(uri, encodeString("Kax"));
        LOG.debug("uri: " + formattedUri);
        RestAssured.given()
                .when()
                .get(formattedUri)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/CitySchema.json"));
    }

    @Test
    public void assertSchemaMultipleResult() {
        String formattedUri = String.format(uri, encodeString("London"));
        LOG.debug("uri: " + formattedUri);
        RestAssured.given()
                .when()
                .get(formattedUri)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/CitySchema.json"));
    }

    @Test
    public void assertSchemaSpecialCharacters() {
        String formattedUri = String.format(uri, encodeString("Al Bayḑā’"));
        LOG.debug("uri: " + formattedUri);
        RestAssured.given()
                .when()
                .get(formattedUri)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/CitySchema.json"));
    }

    private String encodeString(String string) {
        String rawString = string;
        byte[] bytes = StringUtils.getBytesUtf8(rawString);

        return StringUtils.newStringUtf8(bytes);
    }

}
