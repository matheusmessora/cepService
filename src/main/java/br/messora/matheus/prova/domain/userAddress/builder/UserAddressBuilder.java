package br.messora.matheus.prova.domain.userAddress.builder;

import br.messora.matheus.prova.domain.postalAddress.PostalAddress;
import br.messora.matheus.prova.domain.userAddress.UserAddress;
import br.messora.matheus.prova.infrastructure.repository.userAddress.UserAddressEntity;

public class UserAddressBuilder {

    public static AddressBuilderUserStep newBuilder() {
        return new Steps();
    }

    public interface AddressBuilderUserStep {

        AddressBuilderCepStep withUser(Long idUser);
    }

    public interface AddressBuilderCepStep {

        /**
         * Constroi um endereco dado um CEP
         * @param cep
         * @return
         */
        AddressBuilderFinalStep withPostalAddress(PostalAddress cep);
    }

    public interface AddressBuilderFinalStep {

        /**
         * Metodo <b>Opcional</b>.<br />
         * Insere o numero do endereco
         * @param number
         * @return
         */
        AddressBuilderFinalStep withNumber(int number);

        /**
         * Metodo <b>Opcional</b>.<br />
         * Insere o complemento do endereco
         * @param complement
         * @return
         */
        AddressBuilderFinalStep withComplement(String complement);


        UserAddress build();
    }


    private static class Steps implements AddressBuilderFinalStep, AddressBuilderCepStep, AddressBuilderUserStep {

        private int number;
        private String complement;
        private PostalAddress postalAddress;
        private Long iduser;

        @Override
        public AddressBuilderFinalStep withPostalAddress(PostalAddress postalAddress) {
            this.postalAddress = postalAddress;
            return this;
        }

        @Override
        public AddressBuilderFinalStep withNumber(int number) {
            this.number = number;
            return this;
        }

        @Override
        public AddressBuilderFinalStep withComplement(String complement) {
            this.complement = complement;
            return this;
        }

        @Override
        public UserAddress build() {
            return new UserAddressEntity(iduser, postalAddress, number, complement);
        }

        @Override
        public AddressBuilderCepStep withUser(Long idUser) {
            this.iduser = idUser;
            return this;
        }
    }
}
