package integration;

import com.jayway.restassured.http.ContentType;
import integration.shared.IntegrationServer;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddressEndpointIT extends IntegrationServer {

    @Test
    public void should_create_address() {
        given()
            .contentType(ContentType.JSON)
            .body("{ \"cep\": \"01535001\" }")
            .when()
            .post("http://127.0.0.1:15081/address")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_CREATED)
            .and()
            .body("id", equalTo(1));
    }
}
