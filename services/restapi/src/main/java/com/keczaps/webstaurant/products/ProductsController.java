package com.keczaps.webstaurant.products;

import com.keczaps.webstaurant.product.Product;
import com.keczaps.webstaurant.user.User;
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
public class ProductsController {


  private final ProductsService productsService;

  //    @Secured("ROLE_USER")
  @GetMapping(path = "/products",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity getProducts(HttpServletRequest httpServletRequest) {
    return productsService.getProducts(httpServletRequest.getQueryString());
  }

  //    @Secured("ROLE_USER")
  @GetMapping(path = "/products/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity getProduct(@PathParam("id") String id) {
    return productsService.getProduct(id);
  }

  //    @Secured("ROLE_USER")
  @PostMapping(path = "/products", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
          produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity createProduct(@RequestParam Product product) {
    // TODO - validate product
    return productsService.createProduct(product);
  }

  //    @Secured("ROLE_USER")
  @PutMapping(path = "/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity updateProduct(@RequestParam Product product) {
    // TODO - validate product
    return productsService.updateProduct(product);
  }

  //    @Secured("ROLE_USER")
  @DeleteMapping(path = "/products/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity deleteProduct(@PathVariable("id") String id) {
    return productsService.deleteProduct(id);
  }

}
