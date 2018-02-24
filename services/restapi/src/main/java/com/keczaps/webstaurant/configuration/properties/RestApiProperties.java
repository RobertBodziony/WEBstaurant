package com.keczaps.webstaurant.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@Data
@ConfigurationProperties(prefix = "rest-api")
public class RestApiProperties {

    @NotNull
    private String DataApiUrl;

}
