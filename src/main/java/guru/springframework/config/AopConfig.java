package guru.springframework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/** para habilitar manualmente AOP toca agregar al properties
 * #spring.autoconfigure.exclude[7]=org.springframework.boot.autoconfigure.aop.AopAutoConfiguration
 *
 * O
 *
 * @SpringBootApplication(exclude = { AopAutoConfiguration.class })
 *
 * y por ultimo anotar una clase @Configuration con @EnableAspectJAutoProxy
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
}
