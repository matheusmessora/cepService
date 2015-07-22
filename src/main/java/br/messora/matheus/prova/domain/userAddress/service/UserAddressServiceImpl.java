package br.messora.matheus.prova.domain.userAddress.service;

import br.messora.matheus.prova.domain.userAddress.UserAddress;
import br.messora.matheus.prova.infrastructure.repository.userAddress.UserAddressEntity;
import br.messora.matheus.prova.infrastructure.repository.userAddress.UserAddressRepository;
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
