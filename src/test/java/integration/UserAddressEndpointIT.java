package integration;

import com.jayway.restassured.http.ContentType;
import integration.shared.IntegrationServer;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserAddressEndpointIT extends IntegrationServer {

    @Test
    public void should_create_address() {
        given()
            .contentType(ContentType.JSON)
            .body("{ \"cep\": \"01535001\",\"idUser\": 1, \"number\": 110 }")
            .when()
                .post("http://127.0.0.1:15081/address")
            .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
            .and()
                .body("id", equalTo(1))
            .and()
            .body("address", equalTo("Rua Paulo Orozimbo - de 629/630 ao fim"))
            .and()
            .body("number", equalTo(110))
            .and()
            .body("city", equalTo("Sao Paulo"))
            .and()
            .body("uf", equalTo("SP"))
            .and()
            .body("district", equalTo("Cambuci"));
    }

    @Test
    public void should_return_BAD_REQUEST_when_CEP_invalid() {
        given()
            .contentType(ContentType.JSON)
            .body("{ \"cep\": \"12345\",\"idUser\": 1, \"number\": 110 }")
            .when()
                .post("http://127.0.0.1:15081/address")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .and()
            .body("code", equalTo("cep_invalid"));
    }

    @Test
    public void should_return_BAD_REQUEST_when_number_is_empty() {
        given()
            .contentType(ContentType.JSON)
                .body("{ \"cep\": \"01535001\",\"idUser\": 1 }")
            .when()
                .post("http://127.0.0.1:15081/address")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .and()
            .body("code", equalTo("number_mandatory"))
                .and()
            .body("message", equalTo("Numero eh obrigatorio"));
    }

    @Test
    public void should_return_BAD_REQUEST_when_CEP_not_found() {
        given()
            .contentType(ContentType.JSON)
            .body("{ \"cep\": \"01535444\",\"idUser\": 1, \"number\": 110 }")
            .when()
                .post("http://127.0.0.1:15081/address")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .and()
            .body("code", equalTo("postal_address_not_found"));
    }
}
