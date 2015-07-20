package br.messora.matheus.cep.infrastructure.repository.logradouro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {

    Logradouro findByCep(String cep);
}
