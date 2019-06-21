package br.jus.tse.judiciaria.mural.config;

import br.jus.tse.judiciaria.mural.util.ConstantsProjeto;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Classe responsavel por realizar a configuracao da base de dados da aplicação.
 * 
 * @author solimar.alves
 * @since 1.1.1.2
 */
@EnableJpaRepositories(basePackages = {ConstantsProjeto.CARACTER.SCAN_PACOTE_DAO})
@EnableTransactionManagement
public class DBConfig {

    
    /**
     * Metodo responsavel por criar o fabrica de gerenciadores de transacao.
     * 
     * @author solimar.alves
     * @since 1.1.1.2
     * 
     * @return entity manager factory.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPersistenceUnitName(ConstantsProjeto.PERSISTENCE.NOME_PERSISTENCE_UNIT);
        em.setPackagesToScan(ConstantsProjeto.CARACTER.SCAN_PACOTE_BASE_PROJETO);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    /**
     * Metodo responsavel por criar a gerenciador de transacao jpa a partir do EntityManagerFactory.
     * 
     * @author solimar.alves
     * @since 1.1.1.2
     * 
     * @param emf entityManagerFactory
     * @return novo gerenciador de transacao JPA
     */
    @Bean
    public JpaTransactionManager transactionManager(final EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
