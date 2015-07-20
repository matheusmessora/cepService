package br.messora.matheus.cep.domain.postalAddress.service;

import br.messora.matheus.cep.domain.postalAddress.CEP;
import br.messora.matheus.cep.domain.postalAddress.PostalAddress;

public interface PostalAddressService {

    /**
     * Busca um Endereco Postal dado o CEP informado.<br />
     * @param cep
     * @return null caso nenhum endereco tenha sido encontrado
     */
    PostalAddress find(CEP cep);
}
