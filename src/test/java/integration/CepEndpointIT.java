package integration;


import integration.shared.IntegrationServer;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class CepEndpointIT extends IntegrationServer {


    @Test
    public void should_return_postal_address_from_correct_cep() {
        get("http://127.0.0.1:15081/postal_address?cep=01535001")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_OK)
            .and()
                .body("address", equalTo("Rua Paulo Orozimbo - de 629/630 ao fim"))
            .and()
                .body("district", equalTo("Cambuci"))
            .and()
            .body("city", equalTo("Sao Paulo"))
            .and()
            .body("uf", equalTo("SP"));
    }

    @Test
    public void should_return_NOT_FOUND_when_cep_does_not_exist() {
        get("http://127.0.0.1:15081/postal_address?cep=99999123")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
