package br.messora.matheus.cep.domain.userAddress.service;

import br.messora.matheus.cep.domain.postalAddress.PostalAddress;
import br.messora.matheus.cep.domain.postalAddress.service.PostalAddressService;
import br.messora.matheus.cep.domain.userAddress.UserAddress;
import br.messora.matheus.cep.infrastructure.repository.userAddress.UserAddressEntity;
import br.messora.matheus.cep.infrastructure.repository.userAddress.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressRepository repository;

    @Override
    public UserAddress create(UserAddress userAddress) {
        userAddress = persist(userAddress);
        return userAddress;
    }

    private UserAddress persist(UserAddress userAddress) {
        return repository.save((UserAddressEntity) userAddress);
    }
}
