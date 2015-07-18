package br.messora.matheus.cep.boot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("br.com.pandox.lastcloud")
@EnableScheduling
@EnableWebMvc
public class ApplicationInitializer {

    private static final Logger LOGGER = LogManager.getLogger();

    public ApplicationInitializer() throws Exception {
        LOGGER.info("Initializing Application");
    }

}