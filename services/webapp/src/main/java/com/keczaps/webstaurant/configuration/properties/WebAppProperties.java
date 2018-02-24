package com.keczaps.webstaurant.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

@Data
@Configuration
@ConfigurationProperties(prefix = "web-app")
public class WebAppProperties {

  @NotNull
  private String restApiUrl;

}
