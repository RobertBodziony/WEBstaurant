package com.keczaps.webstaurant.ingredients;

import com.keczaps.webstaurant.ingredient.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IngredientsController {

    private final IngredientsRepository ingredientsRepository;

    @GetMapping(path = "/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getIngredients(Sort sort) {
        List<Ingredient> ingredients = ingredientsRepository.findAll(sort);
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping(path = "/ingredients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getIngredient(@PathVariable("id") String id) {
        Ingredient ingredient = ingredientsRepository.findOne(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @PostMapping(path = "/ingredients", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createIngredient(@RequestBody Ingredient ingredient) {
        ingredient.setId(UUID.randomUUID().toString());
        ingredientsRepository.save(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredient);
    }

    @PutMapping(path = "/ingredients", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateIngredient(@RequestBody Ingredient ingredient) {
        Ingredient ingredientMongoInstance = ingredientsRepository.findOne(ingredient.getId());
        if (ingredientMongoInstance == null) {
            return ResponseEntity.notFound().build();
        }
        ingredientMongoInstance = ingredient;
        ingredientsRepository.save(ingredientMongoInstance);
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping(path = "/ingredients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteIngredient(@PathVariable("id") String id) {
        Ingredient ingredient = ingredientsRepository.findOne(id);
        if (ingredient == null){
            return ResponseEntity.notFound().build();
        }
        ingredientsRepository.delete(id);
        return ResponseEntity.ok(ingredient);
    }


}
