package com.keczaps.webstaurant.products;

import com.keczaps.webstaurant.configuration.properties.WebAppProperties;
import com.keczaps.webstaurant.product.Product;
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
public class ProductsService {

  private static final String PRODUCTS_PATH = "products";

  private final RestTemplate restTemplate;
  private final WebAppProperties webAppProperties;

  public ResponseEntity getProducts(String queryString) {
    URI uri = UriComponentsBuilder.fromUriString(webAppProperties.getRestApiUrl())
            .pathSegment(PRODUCTS_PATH).query(queryString)
            .build().toUri();

    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Product>>() {});
  }

  public ResponseEntity getProduct(String id) {
    URI uri = UriComponentsBuilder.fromUriString(webAppProperties.getRestApiUrl())
            .pathSegment(PRODUCTS_PATH,id)
            .build().toUri();

    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, Product.class);
  }

  public ResponseEntity createProduct(Product product) {
    URI uri = UriComponentsBuilder.fromUriString(webAppProperties.getRestApiUrl())
            .pathSegment(PRODUCTS_PATH)
            .build().toUri();

    HttpEntity httpEntity = new HttpEntity(product);

    return restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Product.class);
  }

  public ResponseEntity updateProduct(Product product) {
    URI uri = UriComponentsBuilder.fromUriString(webAppProperties.getRestApiUrl())
            .pathSegment(PRODUCTS_PATH)
            .build().toUri();

    HttpEntity httpEntity = new HttpEntity(product);

    return restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, Product.class);
  }

  public ResponseEntity deleteProduct(String id) {
    URI uri = UriComponentsBuilder.fromUriString(webAppProperties.getRestApiUrl())
            .pathSegment(PRODUCTS_PATH)
            .build().toUri();

    return restTemplate.exchange(uri, HttpMethod.DELETE, HttpEntity.EMPTY, Product.class);
  }

}
