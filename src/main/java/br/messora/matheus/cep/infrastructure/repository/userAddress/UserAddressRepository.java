package br.messora.matheus.cep.infrastructure.repository.userAddress;

import br.messora.matheus.cep.infrastructure.repository.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Long> {
}
