package com.keczaps.webstaurant.orders;

import com.keczaps.webstaurant.order.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface OrdersRepository extends MongoRepository<Order, String> {

    List<Order> findAllByTableNumber(Integer tableNumber, Sort sort);
}
