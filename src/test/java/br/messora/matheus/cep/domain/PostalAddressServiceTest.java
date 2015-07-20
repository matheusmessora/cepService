package br.messora.matheus.cep.domain;

import br.messora.matheus.cep.domain.postalAddress.CEP;
import br.messora.matheus.cep.domain.postalAddress.PostalAddress;
import br.messora.matheus.cep.domain.postalAddress.service.PostalAddressService;
import br.messora.matheus.cep.domain.postalAddress.service.PostalAddressServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PostalAddressServiceTest {

    PostalAddressService service;

    @BeforeMethod
    public void init(){
        service = new PostalAddressServiceImpl();
    }

    @Test
    public void should_return_correct_postal_address_from_correct_CEP(){
        CEP cep = CEP.from("01535001");
        PostalAddress postalAddress = service.find(cep);

        assertEquals(postalAddress.address(), "Rua Paulo Orozimbo");
    }
}
