package br.messora.matheus.prova.domain.postalAddress.service;

import br.messora.matheus.prova.domain.cep.CEP;
import br.messora.matheus.prova.domain.postalAddress.PostalAddress;
import br.messora.matheus.prova.domain.postalAddress.PostalAddressNotFound;

public interface PostalAddressService {

    /**
     * Busca um Endereco Postal dado o CEP informado.<br />
     * @param cep CEP para realizar a pesquisa
     * @return null caso nenhum endereco tenha sido encontrado
     * @throws PostalAddressNotFound caso o CEP nao seja encontrado no repositorio
     */
    PostalAddress find(CEP cep) throws PostalAddressNotFound;
}
