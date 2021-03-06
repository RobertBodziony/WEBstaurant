package com.keczaps.webstaurant.users;

import com.keczaps.webstaurant.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface UsersRepository extends MongoRepository<User,String> {
}
