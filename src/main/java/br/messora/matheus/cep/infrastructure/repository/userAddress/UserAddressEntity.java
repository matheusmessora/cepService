package br.messora.matheus.cep.infrastructure.repository.userAddress;

import br.messora.matheus.cep.domain.cep.CEP;
import br.messora.matheus.cep.domain.postalAddress.PostalAddress;
import br.messora.matheus.cep.domain.userAddress.UserAddress;
import br.messora.matheus.cep.infrastructure.repository.address.AddressEntity;

import javax.persistence.*;

@Entity
public class UserAddressEntity implements UserAddress {


    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long userId;

    @ManyToOne(targetEntity = AddressEntity.class)
    public PostalAddress address;

    @Column
    private Integer number;
    @Column
    private String complement;

    @Transient
    private transient CEP cep;

    public UserAddressEntity(Long userId, PostalAddress postalAddress, Integer number, String complement){
        this.userId = userId;
        this.address = postalAddress;
        this.number = number;
        this.complement = complement;
    }

    public UserAddressEntity(long id) {
        this.id = id;
    }

    @Override
    public Long id() {
        return id;
    }

    @Override
    public CEP cep() {
        return cep;
    }
}
