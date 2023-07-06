package com.github.whp98.springframework.boot.env;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author whp98
 * @version 1.0
 */
@Configuration
public class AppConfig {
    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        Set<Object> set = new HashSet<>();
        set.add(new StringToOffsetDatetimeConverter());
        set.add(new StringToLocalDateTimeConverter());
        set.add(new StringToLocalDateConverter());
        set.add(new StringToLocalTimeConverter());
        factoryBean.setConverters(set);
        return factoryBean;
    }
}

