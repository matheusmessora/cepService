package br.messora.matheus.cep.domain.postalAddress;

/**
 * Value Object de CÓDIGO DE ENDEREÇAMENTO POSTAL<br /><br />
 * <a href="http://martinfowler.com/bliki/ValueObject.html">Value Object - Martin Fowler</a>
 *
 */
public class CEP {

    public static CEP from(String cep) {
        return new CEP();
    }
}
