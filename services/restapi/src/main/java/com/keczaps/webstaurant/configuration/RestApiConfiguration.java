package com.keczaps.webstaurant.configuration;

import com.keczaps.webstaurant.configuration.properties.RestApiProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@Configuration
public class RestApiConfiguration {

    @Bean
    public RestTemplate restTemplate(RestTemplate restTemplate) {
        return restTemplate;
    }

}

