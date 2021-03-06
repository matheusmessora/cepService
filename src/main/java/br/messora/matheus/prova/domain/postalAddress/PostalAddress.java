package br.messora.matheus.prova.domain.postalAddress;

import br.messora.matheus.prova.infrastructure.repository.district.City;

/**
 * Representa um Endereco Postal.<br />
 * Ele eh composto de um endereco de rua, um bairro e a cidade.
 */
public interface PostalAddress {

    /**
     * Representa a rua do Endereço postal.<br />
     * Em algumas cidades menos populosas, os codigos postais nao representam uma rua em especifico, mas sim a propria cidade.<br />
     * Portanto este campo pode vir nulo em caso de CEPs de cidades
     *
     * @return o nome da rua referenciada deste endereço postal<br />
     * null caso este codigo seja de um codigo postal de cidade
     */
    String address();

    /**
     * Representa o bairro
     * @return
     */
    String district();

    City city();
}
