package br.messora.matheus.prova.view.endpoint.userAddress;

import br.messora.matheus.prova.domain.cep.CEP;
import br.messora.matheus.prova.domain.cep.InvalidCEP;
import br.messora.matheus.prova.domain.postalAddress.PostalAddress;
import br.messora.matheus.prova.domain.postalAddress.PostalAddressNotFound;
import br.messora.matheus.prova.domain.postalAddress.service.PostalAddressService;
import br.messora.matheus.prova.domain.userAddress.UserAddress;
import br.messora.matheus.prova.domain.userAddress.UserAddressNotFound;
import br.messora.matheus.prova.domain.userAddress.builder.UserAddressBuilder;
import br.messora.matheus.prova.domain.userAddress.service.UserAddressService;
import br.messora.matheus.prova.view.endpoint.ErroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
public class AddressEndpoint {

    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private PostalAddressService postalAddressService;

    @RequestMapping(value = "/user_address", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody UserAddressDTO dto) {
        check(dto);

        UserAddress address = createUserAddress(dto);

        return parseToResponse(address,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user_address/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable Long id) {

        return parseToResponse(userAddressService.find(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/user_address/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        userAddressService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/user_address/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable Long id, @RequestBody UserAddressDTO dto) {
        UserAddress address = updateUserAddress(id, dto);

        return parseToResponse(address,HttpStatus.OK);
    }

    private UserAddress createUserAddress(UserAddressDTO dto) {
        PostalAddress postalAddress = postalAddressService.find(CEP.from(dto.getCep()));

        UserAddress address = UserAddressBuilder.newBuilder()
                .withUser(dto.getIdUser())
                .withPostalAddress(postalAddress)
                .withNumber(dto.getNumber())
                .withComplement(dto.getComplement())
                .build();

        address = userAddressService.create(address);
        return address;
    }

    private UserAddress updateUserAddress(Long id, UserAddressDTO dto) {
        PostalAddress postalAddress = postalAddressService.find(CEP.from(dto.getCep()));

        UserAddress address = UserAddressBuilder.newBuilder()
                .withId(id)
                .withUser(dto.getIdUser())
                .withPostalAddress(postalAddress)
                .withNumber(dto.getNumber())
                .withComplement(dto.getComplement())
                .build();

        address = userAddressService.update(address);
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

    @ExceptionHandler(UserAddressNotFound.class)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ResponseBody
    public ErroDTO postalAddressNotFoundHandler(UserAddressNotFound ex, HttpServletResponse response) {
        return new ErroDTO("user_address_not_found", "Endereco de usuario nao encontrado");
    }

    private ResponseEntity parseToResponse(UserAddress postalAddress, HttpStatus status) {
        return new ResponseEntity<>(new UserAddressDTO(postalAddress), status);
    }

}
