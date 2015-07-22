package br.messora.matheus.prova.view.endpoint.userAddress;

import br.messora.matheus.prova.domain.cep.CEP;
import br.messora.matheus.prova.domain.cep.InvalidCEP;
import br.messora.matheus.prova.domain.postalAddress.PostalAddress;
import br.messora.matheus.prova.domain.postalAddress.PostalAddressNotFound;
import br.messora.matheus.prova.domain.postalAddress.service.PostalAddressService;
import br.messora.matheus.prova.domain.userAddress.UserAddress;
import br.messora.matheus.prova.domain.userAddress.builder.UserAddressBuilder;
import br.messora.matheus.prova.domain.userAddress.service.UserAddressService;
import br.messora.matheus.prova.view.endpoint.ErroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
public class AddressEndpoint {

    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private PostalAddressService postalAddressService;

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ResponseEntity get(@RequestBody(required = false) UserAddressDTO dto) {
        check(dto);

        UserAddress address = getUserAddress(dto);

        return parseToResponse(address);
    }

    private UserAddress getUserAddress(@RequestBody(required = false) UserAddressDTO dto) {
        PostalAddress postalAddress = postalAddressService.find(CEP.from(dto.getCep()));

        UserAddress address = UserAddressBuilder.newBuilder()
                .withUser(dto.getIdUser())
                .withPostalAddress(postalAddress)
                .withNumber(dto.getNumber())
                .build();

        address = userAddressService.create(address);
        return address;
    }

    private void check(UserAddressDTO dto) {
        if(dto.getNumber() == 0) {
            throw new IllegalArgumentException("number_mandatory");
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErroDTO numberIsEmptyHandler(IllegalArgumentException ex, HttpServletResponse response) {
        return new ErroDTO(ex.getMessage(), "Numero eh obrigatorio");
    }

    @ExceptionHandler(InvalidCEP.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErroDTO notFoundHandler(InvalidCEP ex, HttpServletResponse response) {
        return new ErroDTO("cep_invalid", "CEP invalido");
    }

    @ExceptionHandler(PostalAddressNotFound.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErroDTO postalAddressNotFoundHandler(PostalAddressNotFound ex, HttpServletResponse response) {
        return new ErroDTO("postal_address_not_found", "CEP nao encontrado");
    }

    private ResponseEntity parseToResponse(UserAddress postalAddress) {
        return new ResponseEntity<>(new UserAddressDTO(postalAddress), HttpStatus.CREATED);
    }

}
