package br.jus.tse.judiciaria.mural.config;

import br.jus.tse.corporativa.web.security.TseKeycloakSpringConfigResolver;
import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 * Classe responsavel por realizar a configuracao do adaptador para o Keycloak.
 *
 * @author gabriell.amaral
 * @since 1.0.1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
@EnableConfigurationProperties(KeycloakSpringBootProperties.class)
@ConditionalOnProperty(value = "keycloak.enabled", matchIfMissing = true)
public class SecurityConfiguration extends KeycloakWebSecurityConfigurerAdapter {

    /**
     * Metodo responsavel por executar SimpleAuthorityMapper para garantir que as ROLES nao sejam prefixadas com ROLE_.
     *
     * @author gabriell.amaral
     * @since 1.0.1.0
     *
     * @param auth AuthenticationManagerBuilder
     */
    // Submits the KeycloakAuthenticationProvider to the AuthenticationManager
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    /**
     * Metodo responsavel por definir qual arquivo keycloak-{environment}.json usar em substituicao do Keycloak.json padrao.
     *
     * @author gabriell.amaral
     * @since 1.0.2.0
     *
     * @return keycloak config resolver.
     */
    @Bean
    public KeycloakConfigResolver KeycloakConfigResolver() {
        return new TseKeycloakSpringConfigResolver();
    }

    /**
     * Metodo responsavel por especificar a estrategia de autenticacao de sessao.
     *
     * @author gabriell.amaral
     * @since 1.0.1.0
     *
     * @return session authentication strategy
     */
    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    /**
     * Metodo responsavel por definir quais caminhos de URL devem ser protegidos.
     *
     * @author gabriell.amaral
     * @since 1.0.1.0
     *
     * @param http HttpSecurity
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                .anyRequest().authenticated();
    }
}