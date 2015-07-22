package br.messora.matheus.cep.domain.userAddress.service;

import br.messora.matheus.cep.domain.userAddress.UserAddress;

public interface UserAddressService {

    /**
     * Cria um novo Endereco do Usuario
     * @param userAddress
     * @return
     */
    UserAddress create(UserAddress userAddress);
}
