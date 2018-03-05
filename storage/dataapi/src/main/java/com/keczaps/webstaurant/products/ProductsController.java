package com.keczaps.webstaurant.products;

import com.keczaps.webstaurant.product.Product;
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
public class ProductsController {

    private final ProductsRepository productsRepository;

    @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProducts(Sort sort) {
        List<Product> products = productsRepository.findAll(sort);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProduct(@PathVariable("id") String id) {
        Product product = productsRepository.findOne(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProduct(@RequestBody Product product) {
        product.setId(UUID.randomUUID().toString());
        productsRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@RequestBody Product product) {
        Product productMongoInstance = productsRepository.findOne(product.getId());
        if (productMongoInstance == null) {
            return ResponseEntity.notFound().build();
        }
        productMongoInstance = product;
        productsRepository.save(productMongoInstance);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping(path = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@PathVariable("id") String id) {
        Product product = productsRepository.findOne(id);
        if (product == null){
            return ResponseEntity.notFound().build();
        }
        productsRepository.delete(id);
        return ResponseEntity.ok(product);
    }

}
