package br.jus.tse.judiciaria.mural;

import br.jus.tse.judiciaria.mural.util.ConstantsProjeto;
import br.jus.tse.judiciaria.mural.config.DBConfig;

import org.keycloak.adapters.springboot.KeycloakAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 *
 * @author solimar.alves
 */
//@SpringBootApplication
//esses dois excludes são para tornar público os serviços rest
@SpringBootApplication(exclude = {KeycloakAutoConfiguration.class, SecurityAutoConfiguration.class})
@ComponentScan(basePackages = ConstantsProjeto.CARACTER.SCAN_PACOTE_BASE_PROJETO)
@Import(value = DBConfig.class)
public class SpringWebApplicationInitializer extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        final ApplicationContext applicationContext = SpringApplication.run(SpringWebApplicationInitializer.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(SpringWebApplicationInitializer.class);
    }
}
