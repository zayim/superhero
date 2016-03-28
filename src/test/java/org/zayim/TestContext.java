package org.zayim;

import org.hibernate.SessionFactory;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zayim.service.SuperheroService;

@Configuration
public class TestContext {

    @Bean
    public SuperheroService superheroService() {
        return Mockito.mock(SuperheroService.class);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return Mockito.mock(SessionFactory.class);
    }

}
