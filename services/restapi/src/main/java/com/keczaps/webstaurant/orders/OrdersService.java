package com.keczaps.webstaurant.orders;

import com.keczaps.webstaurant.configuration.properties.RestApiProperties;
import com.keczaps.webstaurant.order.Order;
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
public class OrdersService {

  private static final String ORDERS_PATH = "orders";

  private final RestTemplate restTemplate;
  private final RestApiProperties restApiProperties;

  public ResponseEntity getOrders(String queryString) {
    URI uri = UriComponentsBuilder.fromUriString(restApiProperties.getDataApiUrl())
            .pathSegment(ORDERS_PATH).query(queryString)
            .build().toUri();

    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Order>>() {});
  }

  public ResponseEntity getOrder(String id) {
    URI uri = UriComponentsBuilder.fromUriString(restApiProperties.getDataApiUrl())
            .pathSegment(ORDERS_PATH,id)
            .build().toUri();

    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, Order.class);
  }

  public ResponseEntity createOrder(Order order) {
    URI uri = UriComponentsBuilder.fromUriString(restApiProperties.getDataApiUrl())
            .pathSegment(ORDERS_PATH)
            .build().toUri();

    HttpEntity httpEntity = new HttpEntity(order);

    return restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Order.class);
  }

  public ResponseEntity updateOrder(Order order) {
    URI uri = UriComponentsBuilder.fromUriString(restApiProperties.getDataApiUrl())
            .pathSegment(ORDERS_PATH)
            .build().toUri();

    HttpEntity httpEntity = new HttpEntity(order);

    return restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, Order.class);
  }

  public ResponseEntity deleteOrder(String id) {
    URI uri = UriComponentsBuilder.fromUriString(restApiProperties.getDataApiUrl())
            .pathSegment(ORDERS_PATH,id)
            .build().toUri();

    return restTemplate.exchange(uri, HttpMethod.DELETE, HttpEntity.EMPTY, Order.class);
  }

}