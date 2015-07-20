package integration.shared;

import br.messora.matheus.cep.boot.server.ApplicationServer;
import br.messora.matheus.cep.boot.server.WebServer;
import org.testng.annotations.BeforeClass;

public class IntegrationServer {

    @BeforeClass
    public void init() throws Exception {
        WebServer server = new ApplicationServer();
        server.start();
    }
}
