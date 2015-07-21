package br.messora.matheus.cep.domain.postalAddress.service;

import br.messora.matheus.cep.domain.postalAddress.CEP;
import br.messora.matheus.cep.domain.postalAddress.PostalAddress;
import br.messora.matheus.cep.infrastructure.repository.district.City;
import br.messora.matheus.cep.infrastructure.repository.logradouro.Logradouro;
import br.messora.matheus.cep.infrastructure.repository.logradouro.LogradouroRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class PostalAddressServiceTest {

    @InjectMocks
    PostalAddressServiceImpl service;

    @Mock
    LogradouroRepository logradouroRepository;

    @BeforeMethod
    public void init(){
        service = new PostalAddressServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_return_postal_address_from_correct_CEP(){
        CEP cep = CEP.from("01535001");
        Logradouro mock = new Logradouro("01535001", "Rua Paulo Orozimbo", "Cambuci", new City("Sao Paulo", "SP"));
        mock.setId(1L);
        when(logradouroRepository.findByCep(eq(cep.fullCode()))).thenReturn(mock);

        PostalAddress postalAddress = service.find(cep);

        assertEquals(postalAddress.address(), "Rua Paulo Orozimbo");
    }

    @Test
    public void should_return_district_postal_address_from_correct_CEP(){
        CEP cep = CEP.from("01535001");
        Logradouro mock = new Logradouro("01535001", "Rua Paulo Orozimbo", "Cambuci", new City("Sao Paulo", "SP"));
        mock.setId(1L);
        when(logradouroRepository.findByCep(eq(cep.fullCode()))).thenReturn(mock);

        PostalAddress postalAddress = service.find(cep);

        assertEquals(postalAddress.city().getDescription(), "Sao Paulo");
    }

    @Test
    public void should_return_postal_address_from_CEP_with_last_zero(){
        CEP cep = CEP.from("01535010");
        Logradouro mock = new Logradouro("01535010", "Rua Paulo Orozimbo", "Cambuci", new City("Sao Paulo", "SP"));
        mock.setId(1L);
        when(logradouroRepository.findByCep(eq(cep.fullCode()))).thenReturn(null);
        when(logradouroRepository.findByCep(eq("01535010"))).thenReturn(mock);

        PostalAddress postalAddress = service.find(cep);

        assertEquals(postalAddress.address(), "Rua Paulo Orozimbo");
    }

    @Test
    public void should_return_postal_address_from_CEP_with_last_double_zero(){
        CEP cep = CEP.from("01535111");
        Logradouro mock = new Logradouro("01535000", "Rua Paulo Orozimbo", "Cambuci", new City("Sao Paulo", "SP"));
        mock.setId(1L);
        when(logradouroRepository.findByCep(eq(cep.fullCode()))).thenReturn(null);
        when(logradouroRepository.findByCep(eq("01535111"))).thenReturn(null);
        when(logradouroRepository.findByCep(eq("01535110"))).thenReturn(null);
        when(logradouroRepository.findByCep(eq("01535100"))).thenReturn(null);
        when(logradouroRepository.findByCep(eq("01535000"))).thenReturn(mock);

        PostalAddress postalAddress = service.find(cep);

        assertEquals(postalAddress.address(), "Rua Paulo Orozimbo");
    }

    @Test
    public void should_return_postal_address_from_CEP_with_full_double_zero(){
        CEP cep = CEP.from("01535111");
        Logradouro mock = new Logradouro("00000000", "Rua Paulo Orozimbo", "Cambuci", new City("Sao Paulo", "SP"));
        mock.setId(1L);
        when(logradouroRepository.findByCep(eq("00000000"))).thenReturn(mock);
        when(logradouroRepository.findByCep(Mockito.contains("1"))).thenReturn(null);

        PostalAddress postalAddress = service.find(cep);

        assertEquals(postalAddress.address(), "Rua Paulo Orozimbo");
    }
}
