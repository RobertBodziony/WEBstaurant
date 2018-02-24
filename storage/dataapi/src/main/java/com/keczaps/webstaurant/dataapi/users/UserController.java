package com.keczaps.webstaurant.dataapi.users;

import com.keczaps.webstaurant.dataapi.configuration.DataApiConfiguration;
import com.keczaps.webstaurant.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final MongoTemplate mongoTemplate;
    private final UserRepository userRepository;

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers(Sort sort) {
        List<User> users = userRepository.findAll();
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
        // TODO - user validation
        userMongoInstance = user;
        userRepository.save(userMongoInstance);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@PathVariable("id") String id) {
        userRepository.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
