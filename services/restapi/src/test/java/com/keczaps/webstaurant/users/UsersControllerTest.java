package com.keczaps.webstaurant.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.keczaps.webstaurant.user.User;
import javafx.beans.property.SimpleListProperty;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class UsersControllerTest {

  private UsersController usersController;
  private User userMock;

  @Autowired
  MockMvc mockMvc;

  @MockBean
  private UsersService usersServiceMock;

  @Autowired
  ObjectMapper objectMapper;

  @Before
  public void setUp() throws Exception {
    initMocks(this);
    usersController = new UsersController(usersServiceMock);
    userMock = new User();
    userMock.setId("test");
    userMock.setEmail("test@test.pl");
    userMock.setUsername("test");
    userMock.setFirstName("test");
    userMock.setLastName("test");
    userMock.setPassword("test");
    userMock.setUserRank(User.Rank.FLAVOR_AMATOUR);
    userMock.setAuthorities(Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER")));
    userMock.setCreatedAt(LocalDateTime.of(2018,2,10,8,32,16));
    userMock.setOrders(Lists.newArrayList());
    userMock.setEnabled(true);
    userMock.setCredentialsNonExpired(true);
    userMock.setAccountNonLocked(true);
    userMock.setAccountNonExpired(true);

  }

  @Test
  public void getUser() throws Exception {

    String userId = "testtest";

    given(usersServiceMock.getUser(userId)).willReturn(ResponseEntity.ok(userMock));

    URI uri = UriComponentsBuilder.fromUriString("http://localhost:8100/users").build().toUri();

    mockMvc.perform(get(uri))
            .andExpect(status().is2xxSuccessful());
  }
}
