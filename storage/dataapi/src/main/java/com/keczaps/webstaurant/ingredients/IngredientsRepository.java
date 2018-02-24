package com.keczaps.webstaurant.ingredients;

import com.keczaps.webstaurant.ingredient.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface IngredientsRepository extends MongoRepository<Ingredient, String> {
}
