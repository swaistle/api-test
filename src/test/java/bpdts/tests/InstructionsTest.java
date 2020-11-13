package bpdts.tests;

import bpdts.utility.ScenarioContext;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class InstructionsTest {

    public String uri = ScenarioContext.getUrl() + "/instructions";

    @Test
    public void assertStatusEquals200() throws IOException {
        RestAssured.given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(200);
    }

}
