package bpdts.tests;

import bpdts.utility.Environment;
import bpdts.utility.RandomCityGenerator;
import bpdts.utility.RandomNumberGenerator;
import io.restassured.RestAssured;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CityTest {
    private static final Logger LOG = LoggerFactory.getLogger(CityTest.class);

    String rawString = RandomCityGenerator.randomCity();
    byte[] bytes = StringUtils.getBytesUtf8(rawString);

    String utf8EncodedString = StringUtils.newStringUtf8(bytes);

    public String uri = Environment.getAppUrl() + "/city/" + utf8EncodedString + "/users";

    @Test
    public void assertStatusEquals200() {
        LOG.debug("uri: " + uri);
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void assertSchema() {
        LOG.debug("uri: " + uri);
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("CitySchema.json"));
    }

}
