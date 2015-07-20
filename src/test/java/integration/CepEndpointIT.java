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
                .body("address", equalTo("Rua Paulo Orozimbo"))
            .and()
            .body("district.city.state.country.code", equalTo("BR"))
            .and()
            .body("district.city.state.country.name", equalTo("BRAZIL"))
            .and()
            .body("district.city.code", equalTo("SP"))
            .and()
            .body("district.city.name", equalTo("São Paulo"))
            .and()
            .body("district.city.state.code", equalTo("SP"))
            .and()
            .body("district.name", equalTo("Cambuci"));


    }
}
