package com.appliance.AFAPP.configue;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;






@Configuration
public class Confuguration {
    @Bean
    DozerBeanMapper dozerBeanMapper() {
        return new DozerBeanMapper();
    }









}
