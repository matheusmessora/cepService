package br.messora.matheus.cep.domain;

import br.messora.matheus.cep.domain.postalAddress.CEP;
import br.messora.matheus.cep.domain.postalAddress.PostalAddress;
import br.messora.matheus.cep.infrastructure.repository.logradouro.Logradouro;
import br.messora.matheus.cep.infrastructure.repository.logradouro.LogradouroRepository;
import br.messora.matheus.cep.domain.postalAddress.service.PostalAddressService;
import br.messora.matheus.cep.domain.postalAddress.service.PostalAddressServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class PostalAddressServiceTest {

    @InjectMocks
    PostalAddressService service;

    @Mock
    LogradouroRepository logradouroRepository;

    @BeforeMethod
    public void init(){
        service = new PostalAddressServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_return_correct_postal_address_from_correct_CEP(){
        CEP cep = CEP.from("01535001");
        Logradouro mock = new Logradouro();
        mock.setDescription("Rua Paulo Orozimbo");
        mock.setCEP("01535001");
        mock.setId(1L);
        when(logradouroRepository.findByCEP(cep.fullCode())).thenReturn(mock);

        PostalAddress postalAddress = service.find(cep);

        assertEquals(postalAddress.address(), "Rua Paulo Orozimbo");
    }
}
