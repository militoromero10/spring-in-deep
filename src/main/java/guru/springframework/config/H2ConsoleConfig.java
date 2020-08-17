package guru.springframework.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Para poder utilizar la consola de H2 en el properties hay que ajustar lo siguiente
 * spring.autoconfigure.exclude[2]=org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration
 *
 * o usar
 * @SpringBootApplication(exclude = {H2ConsoleAutoConfiguration.class})
 *
 */
@Configuration
public class H2ConsoleConfig {
    @Bean
    public ServletRegistrationBean h2Console() {
        String path = "/h2-console";
        String urlMapping = (path.endsWith("/") ? path + "*" : path + "/*");
        return new ServletRegistrationBean(new WebServlet(), urlMapping);
    }
}