package br.messora.matheus.prova.domain.userAddress.service;

import br.messora.matheus.prova.domain.userAddress.UserAddress;
import br.messora.matheus.prova.domain.userAddress.UserAddressNotFound;
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

    @Override
    public UserAddress find(Long id) throws UserAddressNotFound {
        UserAddressEntity one = repository.findOne(id);
        if(one == null) {
            throw new UserAddressNotFound();
        }
        return one;
    }

    @Override
    public void delete(Long id) {
        UserAddress userAddress = find(id);
        delete(userAddress);
    }

    private void delete(UserAddress userAddress) {
        repository.delete((UserAddressEntity) userAddress);
    }

    @Override
    public UserAddress update(UserAddress updatedAddress) {
        checkIfExists(updatedAddress);
        persist(updatedAddress);
        return updatedAddress;
    }

    private void checkIfExists(UserAddress address) {
        find(address.id());
    }

    private UserAddress persist(UserAddress userAddress) {
        return repository.save((UserAddressEntity) userAddress);
    }
}
