package br.messora.matheus.cep.domain.postalAddress;

import br.messora.matheus.cep.infrastructure.repository.district.City;

/**
 * Representa um Endereco Postal
 */
public interface PostalAddress {

    String address();

    String district();

    City city();
}
