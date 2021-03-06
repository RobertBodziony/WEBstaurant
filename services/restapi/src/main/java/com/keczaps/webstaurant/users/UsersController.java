package com.keczaps.webstaurant.users;

import com.keczaps.webstaurant.user.User;
import com.keczaps.webstaurant.user.User.Rank;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import javax.xml.ws.Response;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@EnableSpringDataWebSupport
@CrossOrigin(origins = "http://localhost:8001")
public class UsersController {

    private final UsersService usersService;

//    @Secured("ROLE_USER")
    @GetMapping(path = "/users",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity getUsers(HttpServletRequest httpServletRequest) {
      return usersService.getUsers(httpServletRequest.getQueryString());
    }

//    @Secured("ROLE_USER")
    @GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity getUser(@PathVariable("id") String id) {
      return usersService.getUser(id);
    }

//    @Secured("ROLE_USER")
    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity createUser(@RequestBody User user) {
      // TODO - validate user
      return usersService.createUser(user);
    }

//    @Secured("ROLE_USER")
    @PutMapping(path = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity updateUser(@RequestBody User user) {
      // TODO - validate user
      return usersService.updateUser(user);
    }

//    @Secured("ROLE_USER")
    @DeleteMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity deleteUser(@PathVariable("id") String id) {
      return usersService.deleteUser(id);
    }

    // TODO - getUserOrders
}
