package br.messora.matheus.cep.domain.cep;

public class InvalidCEP extends RuntimeException {
    public InvalidCEP(String message) {
        super(message);
    }
}
