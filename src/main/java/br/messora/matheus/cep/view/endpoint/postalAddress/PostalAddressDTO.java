package br.messora.matheus.cep.view.endpoint.postalAddress;

import br.messora.matheus.cep.domain.postalAddress.PostalAddress;
import br.messora.matheus.cep.infrastructure.repository.district.City;

/**
 * Classe responsavel por fazer a transferencia de data entre cliente-servidor<br />
 * Eh a representacao do JSON nos endpoints RESt
 */
public class PostalAddressDTO {

    private String address;
    private String city;
    private String uf;
    private String district;

    public PostalAddressDTO(PostalAddress postalAddress) {
        buildAddress(postalAddress);
        buildCity(postalAddress.city());
    }

    private void buildAddress(PostalAddress postalAddress) {
        this.address = postalAddress.address();
        this.district = postalAddress.district();
    }

    private void buildCity(City city) {
        this.city = city.getDescription();
        this.uf = city.getUf();
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getUf() {
        return uf;
    }

    public String getDistrict() {
        return district;
    }
}
