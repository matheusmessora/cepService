package br.messora.matheus.cep.domain.postalAddress;

import br.messora.matheus.cep.infrastructure.repository.district.City;
import br.messora.matheus.cep.infrastructure.repository.logradouro.Logradouro;

public class PostalAddressImpl implements PostalAddress {

    private final Logradouro logradouro;

    public PostalAddressImpl(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public String address() {
        return logradouro.getDescription();
    }

    @Override
    public String district() {
        return logradouro.getDistrict();
    }

    @Override public City city() {
        return logradouro.getCity();
    }
}
