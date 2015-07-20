package br.messora.matheus.cep.infrastructure.repository.logradouro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

//@Repository
//@RepositoryDefinition(domainClass = Logradouro.class, idClass = Long.class)
public interface LogradouroRepository extends CrudRepository<Logradouro, Long> {

    Logradouro findByCEP(String cep);
}
