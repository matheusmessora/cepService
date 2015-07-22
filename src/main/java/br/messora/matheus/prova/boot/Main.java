package br.messora.matheus.prova.boot;

import br.messora.matheus.prova.boot.server.ApplicationServer;
import br.messora.matheus.prova.boot.server.WebServer;

public class Main {


    public static void main(String[] args) throws Exception {
        WebServer server = new ApplicationServer();
        server.start();
    }

}