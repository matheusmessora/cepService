package br.messora.matheus.cep.view.endpoint.userAddress;

import br.messora.matheus.cep.domain.postalAddress.PostalAddress;
import br.messora.matheus.cep.view.endpoint.ErroDTO;
import br.messora.matheus.cep.view.endpoint.postalAddress.PostalAddressDTO;
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

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ResponseEntity get(@RequestBody PostalAddressDTO dto) {
        return parseToResponse(null);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErroDTO notFoundHandler(IllegalArgumentException ex, HttpServletResponse response) {
        return new ErroDTO("cep_invalid", "CEP invalido");
    }

    private ResponseEntity parseToResponse(PostalAddress postalAddress) {
        ResponseEntity responseEntity = notFound();
        if (postalAddress != null) {
            responseEntity = ok(postalAddress);
        }
        return responseEntity;
    }

    private ResponseEntity ok(PostalAddress postalAddress) {
        return new ResponseEntity<>(new PostalAddressDTO(postalAddress), HttpStatus.CREATED);
    }

    private ResponseEntity notFound() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
