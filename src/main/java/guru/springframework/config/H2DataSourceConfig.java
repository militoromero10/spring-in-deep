package guru.springframework.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * Para poder utilizarlo en el properties hay que ajustar lo siguiente
 * spring.autoconfigure.exclude[1]=org.springframework.boot.autoconfigure.DataSourceAutoConfiguration
 *
 * o usar
 * @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 *
 */

/** Configurar manualmente un PlatformTransactionManager debemos anotar una clase @Configuration con @EnableTransactionManagement e
 *  implementar la interfaz TransactionManagementConfigurer sobreescribir el metodo annotationDrivenTransactionManager e inyectarle
 *  un  DataSourceTransactionManager con nuestro datasource que en este caso se encuentra en la misma clase
 */

@Configuration
@EnableTransactionManagement
public class H2DataSourceConfig implements TransactionManagementConfigurer {

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager txManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager();
    }
}
