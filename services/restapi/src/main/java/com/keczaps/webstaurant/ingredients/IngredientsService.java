package com.keczaps.webstaurant.ingredients;

import com.keczaps.webstaurant.configuration.properties.RestApiProperties;
import com.keczaps.webstaurant.ingredient.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IngredientsService {

  private static final String INGREDIENTS_PATH = "ingredients";

  private final RestTemplate restTemplate;
  private final RestApiProperties restApiProperties;

  public ResponseEntity getIngredients(String queryString) {
    URI uri = UriComponentsBuilder.fromUriString(restApiProperties.getDataApiUrl())
            .pathSegment(INGREDIENTS_PATH).query(queryString)
            .build().toUri();

    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Ingredient>>() {});
  }

  public ResponseEntity getIngredient(String id) {
    URI uri = UriComponentsBuilder.fromUriString(restApiProperties.getDataApiUrl())
            .pathSegment(INGREDIENTS_PATH,id)
            .build().toUri();

    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, Ingredient.class);
  }

  public ResponseEntity createIngredient(Ingredient ingredient) {
    URI uri = UriComponentsBuilder.fromUriString(restApiProperties.getDataApiUrl())
            .pathSegment(INGREDIENTS_PATH)
            .build().toUri();

    HttpEntity httpEntity = new HttpEntity(ingredient);

    return restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Ingredient.class);
  }

  public ResponseEntity updateIngredient(Ingredient ingredient) {
    URI uri = UriComponentsBuilder.fromUriString(restApiProperties.getDataApiUrl())
            .pathSegment(INGREDIENTS_PATH)
            .build().toUri();

    HttpEntity httpEntity = new HttpEntity(ingredient);

    return restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, Ingredient.class);
  }

  public ResponseEntity deleteIngredient(String id) {
    URI uri = UriComponentsBuilder.fromUriString(restApiProperties.getDataApiUrl())
            .pathSegment(INGREDIENTS_PATH,id)
            .build().toUri();

    return restTemplate.exchange(uri, HttpMethod.DELETE, HttpEntity.EMPTY, Ingredient.class);
  }


}
