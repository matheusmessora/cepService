package br.messora.matheus.cep.domain.postalAddress.service;

import br.messora.matheus.cep.domain.postalAddress.CEP;
import br.messora.matheus.cep.domain.postalAddress.PostalAddress;
import br.messora.matheus.cep.domain.postalAddress.PostalAddressImpl;
import br.messora.matheus.cep.infrastructure.repository.logradouro.Logradouro;
import br.messora.matheus.cep.infrastructure.repository.logradouro.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostalAddressServiceImpl implements PostalAddressService {

    @Autowired
    private LogradouroRepository repository;

    @Override
    public PostalAddress find(CEP cep) {
        Logradouro logradouro = repository.findByCep(cep.fullCode());
        return new PostalAddressImpl(logradouro);
    }
}


