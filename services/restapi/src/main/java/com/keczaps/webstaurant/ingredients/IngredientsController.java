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

  //    @Secured("ROLE_USER")
  @GetMapping(path = "/ingredients",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity getIngredients(HttpServletRequest httpServletRequest) {
    return ingredientsService.getIngredient(httpServletRequest.getQueryString());
  }

  //    @Secured("ROLE_USER")
  @GetMapping(path = "/ingredients/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity getIngredient(@PathParam("id") String id) {
    return ingredientsService.getIngredient(id);
  }

  //    @Secured("ROLE_USER")
  @PostMapping(path = "/ingredients", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
          produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity createIngredient(@RequestParam Ingredient ingredient) {
    // TODO - validate Ingredient
    return ingredientsService.createIngredient(ingredient);
  }

  //    @Secured("ROLE_USER")
  @PutMapping(path = "/ingredients", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity updateIngredient(@RequestParam Ingredient ingredient) {
    // TODO - validate Ingredient
    return ingredientsService.updateIngredient(ingredient);
  }

  //    @Secured("ROLE_USER")
  @DeleteMapping(path = "/ingredients/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity deleteIngredient(@PathVariable("id") String id) {
    return ingredientsService.deleteIngredient(id);
  }

}

