package br.messora.matheus.cep.domain.postalAddress;

import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class CEPTest {

    @Test
    public void should_instantiate_from_static_method() {
        CEP cep = CEP.from("01535001");

        String suffix = cep.suffix();
        assertEquals(suffix, "001");
    }

}