package br.messora.matheus.cep.infrastructure.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    AddressEntity findByCep(String cep);
}
