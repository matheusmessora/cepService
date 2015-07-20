package br.messora.matheus.cep.view.endpoint;

/**
 * Classe responsavel por fazer a transferencia de data entre cliente-servidor
 */
public class PostalAddressDTO {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
