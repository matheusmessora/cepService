# cepService
Servico de busca de endereco atraves do CEP (playground)

O modelo de CEP (CEP.java) foi baseado no artigo da Wikipedia (https://pt.wikipedia.org/wiki/C%C3%B3digo_de_Endere%C3%A7amento_Postal)

[![Build Status](https://travis-ci.org/matheusmessora/cepService.svg)](https://travis-ci.org/matheusmessora/cepService)

1- Serviço de busca de CEP
O servico esta documentado atraves do teste integrado em PostalAddressEndpointIT.java
O CEP oficial 77599999 nao possui nem endereço e nem bairro, apenas cidade e estado. Este CEP é de uma única cidade do Tocantins.
Alguns testes cobrem este cenario