package com.keczaps.webstaurant.users;

import com.keczaps.webstaurant.configuration.properties.WebAppProperties;
import com.keczaps.webstaurant.user.User;
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
public class UsersService {

    private static final String USERS_PATH = "users";

    private final RestTemplate restTemplate;
    private final WebAppProperties webAppProperties;

  public ResponseEntity getUsers(String queryString) {
    URI uri = UriComponentsBuilder.fromUriString(webAppProperties.getRestApiUrl())
            .pathSegment(USERS_PATH).query(queryString)
            .build().toUri();

    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<User>>() {});
  }

  public ResponseEntity getUser(String id) {
    URI uri = UriComponentsBuilder.fromUriString(webAppProperties.getRestApiUrl())
            .pathSegment(USERS_PATH,id)
            .build().toUri();

    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, User.class);
  }

  public ResponseEntity createUser(User user) {
    URI uri = UriComponentsBuilder.fromUriString(webAppProperties.getRestApiUrl())
            .pathSegment(USERS_PATH)
            .build().toUri();

    HttpEntity httpEntity = new HttpEntity(user);

    return restTemplate.exchange(uri, HttpMethod.POST, httpEntity, User.class);
  }

  public ResponseEntity updateUser(User user) {
    URI uri = UriComponentsBuilder.fromUriString(webAppProperties.getRestApiUrl())
            .pathSegment(USERS_PATH)
            .build().toUri();

    HttpEntity httpEntity = new HttpEntity(user);

    return restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, User.class);
  }

  public ResponseEntity deleteUser(String id) {
    URI uri = UriComponentsBuilder.fromUriString(webAppProperties.getRestApiUrl())
            .pathSegment(USERS_PATH)
            .build().toUri();

    return restTemplate.exchange(uri, HttpMethod.DELETE, HttpEntity.EMPTY, User.class);
  }

}
