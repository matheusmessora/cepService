package br.messora.matheus.cep.boot.database;

import br.messora.matheus.cep.infrastructure.repository.district.City;
import br.messora.matheus.cep.infrastructure.repository.logradouro.Logradouro;
import br.messora.matheus.cep.infrastructure.repository.logradouro.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("staging")
public class DatabaseInitializer {

    @Autowired
    private LogradouroRepository repository;

    @PostConstruct
    public void init() {
        Logradouro entity = new Logradouro("01535001", "Rua Paulo Orozimbo - de 629/630 ao fim", "Cambuci", new City("Sao Paulo", "SP"));
        repository.save(entity);

        entity = new Logradouro("01504001", "Rua Vergueiro - até 1289 - lado ímpar", "Liberdade", new City("Sao Paulo", "SP"));
        repository.save(entity);

        entity = new Logradouro("01504001", "Rua Vergueiro - até 1289 - lado ímpar", "Liberdade", new City("Sao Paulo", "SP"));
        repository.save(entity);

        entity = new Logradouro("77500000", null, null, new City("Porto Nacional", "TO"));
        repository.save(entity);
    }

}
