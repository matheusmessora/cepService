package br.messora.matheus.cep.domain.postalAddress;

import br.messora.matheus.cep.infrastructure.repository.logradouro.Logradouro;

public class PostalAddressImpl implements PostalAddress {

    private final String address;

    public PostalAddressImpl(Logradouro logradouro) {
        this.address = logradouro.getDescription();
    }

    @Override
    public String address() {
        return address;
    }
}
