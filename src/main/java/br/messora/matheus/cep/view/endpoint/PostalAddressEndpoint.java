package br.messora.matheus.cep.view.endpoint;

import br.messora.matheus.cep.domain.postalAddress.CEP;
import br.messora.matheus.cep.domain.postalAddress.PostalAddress;
import br.messora.matheus.cep.domain.postalAddress.service.PostalAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PostalAddressEndpoint {

    @Autowired
    private PostalAddressService service;

    @RequestMapping(value = "/postal_address", method = RequestMethod.GET)
    public ResponseEntity get(@RequestParam("cep") String cep) {
        PostalAddress postalAddress = service.find(CEP.from(cep));
        return parseToResponse(postalAddress);
    }

    private ResponseEntity parseToResponse(PostalAddress postalAddress) {
        ResponseEntity responseEntity = notFound();
        if (postalAddress != null) {
            responseEntity = ok(postalAddress);
        }
        return responseEntity;
    }

    private ResponseEntity ok(PostalAddress postalAddress) {
        return new ResponseEntity<>(new PostalAddressDTO(postalAddress), HttpStatus.OK);
    }

    private ResponseEntity notFound() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
