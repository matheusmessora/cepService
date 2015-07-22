package br.messora.matheus.cep.view.endpoint.userAddress;

import br.messora.matheus.cep.domain.userAddress.UserAddress;

public class UserAddressDTO {

    private Long id;
    private Long idUser;
    private String cep;

    public UserAddressDTO() {
    }

    public UserAddressDTO(UserAddress userAddress) {
        this.id = userAddress.id();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
