package br.messora.matheus.cep.boot;

import br.messora.matheus.cep.boot.server.ApplicationServer;
import br.messora.matheus.cep.boot.server.WebServer;

public class Main {


    public static void main(String[] args) throws Exception {
        WebServer server = new ApplicationServer();
        server.start();
    }

}