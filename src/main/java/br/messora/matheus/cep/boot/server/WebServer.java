package br.messora.matheus.cep.boot.server;

public interface WebServer {

    /**
     * Inicializa o servidor da aplicacao.<br />
     * A porta eh selecionada randomicamente
     * @throws Exception
     */
    void start() throws Exception;


    /**
     * Inicializa o servidor da aplicacao na porta especifica.
     * @param port numero da porta especifica em que o servidor deve rodar
     * @throws Exception
     */
    void start(int port) throws Exception;


    /**
     * Para o servidor da aplicacao
     * @throws Exception
     */
    void stop() throws Exception;
}
