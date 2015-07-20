package br.messora.matheus.cep.domain.postalAddress;

/**
 * Value Object de CÓDIGO DE ENDEREÇAMENTO POSTAL<br /><br />
 * <a href="http://martinfowler.com/bliki/ValueObject.html">Value Object - Martin Fowler</a>
 * <br /><br />
 * Esta classe tem como base de conhecimento <br />a descricao na <a href="https://pt.wikipedia.org/wiki/C%C3%B3digo_de_Endere%C3%A7amento_Postal">Wikipedia</a>.<br />
 *
 */
public final  class CEP {

    private String suffix;

    private String fullCode;

    private CEP(String cep) {
        suffix = cep.substring(5);
    }

    public static CEP from(String cep) {
        return new CEP(cep);
    }

    /**
     * Retorna apenas o sufixo do CEP.<br />
     Ex. retorna 001 caso o cep informado seja 01535001
     * @return
     */
    public String suffix() {
        return suffix;
    }

    /**
     * Retorna o codigo do CEP. <br />
     * Ex. 01535001
     * @return
     */
    public String fullCode() {
        return fullCode;
    }

}
