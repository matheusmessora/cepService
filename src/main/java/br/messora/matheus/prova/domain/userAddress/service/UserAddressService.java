package br.messora.matheus.prova.domain.userAddress.service;

import br.messora.matheus.prova.domain.userAddress.UserAddress;

public interface UserAddressService {

    /**
     * Cria um novo Endereco do Usuario
     * @param userAddress
     * @return
     */
    UserAddress create(UserAddress userAddress);
}
