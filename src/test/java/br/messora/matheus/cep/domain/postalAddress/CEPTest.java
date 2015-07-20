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

    @Test
    public void should_throw_illegalArgument_if_invalid_cep() {
        try {
            CEP.from("015350019");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "CEP [015350019] invalido");
        }
    }

    @Test
    public void should_throw_illegalArgument_if_cep_contains_chars() {
        try {
            CEP.from("01535X01");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "CEP [01535X01] invalido");
        }
    }

    @Test
    public void should_throw_illegalArgument_if_cep_empty() {
        try {
            CEP.from("");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "CEP [] invalido");
        }
    }

    @Test
    public void should_instantiate_if_cep_contains_dash() {
        CEP cep = CEP.from("01535-001");
        assertEquals(cep.suffix(), "001");
        assertEquals(cep.fullCode(), "01535001");
    }

}
