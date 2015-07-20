package br.messora.matheus.cep.view.endpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PostalAddressEndpoint {

    private static final Logger LOGGER = LogManager.getLogger();


    @RequestMapping(value = "/postal_address", method = RequestMethod.GET)
    public ResponseEntity<PostalAddressDTO> get() {
        return new ResponseEntity<>(new PostalAddressDTO(), HttpStatus.OK);
    }
}
