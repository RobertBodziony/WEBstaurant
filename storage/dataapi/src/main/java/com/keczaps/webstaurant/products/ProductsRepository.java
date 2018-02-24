package com.keczaps.webstaurant.products;

import com.keczaps.webstaurant.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface ProductsRepository extends MongoRepository<Product,String> {
}
