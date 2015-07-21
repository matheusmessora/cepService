package br.messora.matheus.cep.infrastructure.repository.logradouro;

import br.messora.matheus.cep.infrastructure.repository.district.City;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Logradouro {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String cep;

    @Column
    private String description;

    @Column
    private String district;

    @ManyToOne(cascade = CascadeType.ALL)
    public City city;

    public Logradouro() {
    }

    public Logradouro(String cep, String logradouro, String district, City city) {
        this.cep = cep;
        this.description = logradouro;
        this.district = district;
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
