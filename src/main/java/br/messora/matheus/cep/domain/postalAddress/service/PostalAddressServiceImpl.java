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
        PostalAddress postalAddress = null;
        Logradouro logradouro = findLogradouro(cep);

        if(logradouro != null) {
            postalAddress = new PostalAddressImpl(logradouro);
        }
        return postalAddress;
    }

    private Logradouro findLogradouro(CEP cep) {
        Logradouro logradouro = null;
        for(int lastZerosCount = 0; lastZerosCount < cep.fullCode().length(); lastZerosCount++){
            logradouro = repository.findByCep(cep.fullCode());
            if(logradouro == null){
                cep = nextCEP(cep, lastZerosCount+1);
            }
        }
        return logradouro;
    }

    /**
     * Gera um novo CEP com o ultimo zero a direita adicionado a partir de um CEP especifico.<br />
     * Ex. Caso seja informado 01535999, o novo CEp retornado sera 01535990.<br />
     * Caso seja informado 01535990, o novo CEP retornado sera 01535900
     */
    private CEP nextCEP(CEP cep, int lastZerosCount) {
        String fullCode = cep.fullCode();

        String zeros = "";
        while (zeros.length() < lastZerosCount) {
            zeros = zeros + "0";
        }
        String cepCode = fullCode.substring(0, fullCode.length() - lastZerosCount) + zeros;
        return CEP.from(cepCode);
    }
}


