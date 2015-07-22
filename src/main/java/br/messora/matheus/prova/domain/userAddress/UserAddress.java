package br.messora.matheus.prova.domain.userAddress;

import br.messora.matheus.prova.domain.cep.CEP;
import br.messora.matheus.prova.domain.postalAddress.PostalAddress;

public interface UserAddress {

    Long id();

    Long idUser();

    CEP cep();

    PostalAddress address();
}
