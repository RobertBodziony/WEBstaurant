package com.keczaps.webstaurant.ingredients;

import com.keczaps.webstaurant.ingredient.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@EnableSpringDataWebSupport
public class IngredientsController {

  private final IngredientsService ingredientsService;

  @GetMapping(path = "/ingredients",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity getIngredients(HttpServletRequest httpServletRequest) {
    return ingredientsService.getIngredient(httpServletRequest.getQueryString());
  }

  @GetMapping(path = "/ingredients/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity getIngredient(@PathVariable("id") String id) {
    return ingredientsService.getIngredient(id);
  }

  @PostMapping(path = "/ingredients", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
          produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity createIngredient(@RequestParam Ingredient ingredient) {
    return ingredientsService.createIngredient(ingredient);
  }

  @PutMapping(path = "/ingredients", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity updateIngredient(@RequestParam Ingredient ingredient) {
    return ingredientsService.updateIngredient(ingredient);
  }

  @DeleteMapping(path = "/ingredients/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity deleteIngredient(@PathVariable("id") String id) {
    return ingredientsService.deleteIngredient(id);
  }

}

