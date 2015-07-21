package br.messora.matheus.cep.view.endpoint;

import br.messora.matheus.cep.domain.postalAddress.PostalAddress;

/**
 * Classe responsavel por fazer a transferencia de data entre cliente-servidor
 */
public class PostalAddressDTO {

    private String address;

    public PostalAddressDTO(PostalAddress postalAddress) {
        setAddress(postalAddress.address());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
