package integration.shared;

import br.messora.matheus.prova.boot.server.ApplicationServer;
import br.messora.matheus.prova.boot.server.WebServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class IntegrationServer {

    WebServer server;

    @BeforeClass
    public void init() throws Exception {
        server = new ApplicationServer();
        server.start();
    }

    @AfterClass
    public void destroy() throws Exception {
        server.stop();
    }
}
