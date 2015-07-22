package br.messora.matheus.cep.domain.userAddress.service;

import br.messora.matheus.cep.domain.cep.CEP;
import br.messora.matheus.cep.domain.userAddress.UserAddress;
import br.messora.matheus.cep.domain.userAddress.builder.UserAddressBuilder;
import br.messora.matheus.cep.infrastructure.repository.address.AddressEntity;
import br.messora.matheus.cep.infrastructure.repository.district.City;
import br.messora.matheus.cep.infrastructure.repository.userAddress.UserAddressEntity;
import br.messora.matheus.cep.infrastructure.repository.userAddress.UserAddressRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class UserAddressServiceTest {

    @InjectMocks
    UserAddressServiceImpl service;

    @Mock
    UserAddressRepository repository;

    @BeforeMethod
    public void init(){
        service = new UserAddressServiceImpl();
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void should_persist_new_address_with_CEP_number_and_complement(){

        AddressEntity mock = new AddressEntity("01535001", "Rua Paulo Orozimbo", "Cambuci", new City("Sao Paulo", "SP"));
        UserAddress userAddress = UserAddressBuilder.newBuilder()
                .withUser(1L)
                .withPostalAddress(mock)
                .withNumber(110)
                .withComplement("casa")
                .build();

        when(repository.save((UserAddressEntity) any())).thenReturn(new UserAddressEntity(1L));
        userAddress = service.create(userAddress);
        assertEquals(userAddress.id().longValue(), 1L);
    }

}
