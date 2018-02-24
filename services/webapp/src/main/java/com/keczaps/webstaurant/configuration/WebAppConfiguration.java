package com.keczaps.webstaurant.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.validation.groups.ConvertGroup;

@Configuration
public class WebAppConfiguration {

  @Bean
  public RestTemplate restTemplate(RestTemplate restTemplate) {
    return restTemplate;
  }

}
