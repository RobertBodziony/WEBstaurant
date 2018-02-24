package com.keczaps.webstaurant.users;

import com.google.common.collect.Lists;
import com.keczaps.webstaurant.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersController {

    private final UsersRepository userRepository;

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers(Sort sort) {
        List<User> users = userRepository.findAll(sort);
        return ResponseEntity.ok(users);
    }

    @GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUser(@PathVariable("id") String id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody User user) {
        user.setId(UUID.randomUUID().toString());
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setAuthorities(Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER")));
        user.setUserRank(User.Rank.FLAVOR_AMATOUR);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody User user) {
        User userMongoInstance = userRepository.findOne(user.getId());
        if (userMongoInstance == null) {
            return ResponseEntity.notFound().build();
        }
        userMongoInstance = user;
        userRepository.save(userMongoInstance);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@PathVariable("id") String id) {
        User user = userRepository.findOne(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(id);
        return ResponseEntity.ok(user);
    }

}
