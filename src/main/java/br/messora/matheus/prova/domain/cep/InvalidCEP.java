package br.messora.matheus.prova.domain.cep;

public class InvalidCEP extends RuntimeException {
    public InvalidCEP(String message) {
        super(message);
    }
}
