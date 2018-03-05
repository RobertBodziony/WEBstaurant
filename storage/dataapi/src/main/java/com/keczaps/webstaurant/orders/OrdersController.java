package com.keczaps.webstaurant.orders;

import com.google.common.base.Strings;
import com.keczaps.webstaurant.order.Order;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrdersController {

    private final OrdersRepository ordersRepository;

    @GetMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrders(Sort sort, @RequestParam(value = "table_number", required = false) String tableNumber) {
        if (!Strings.isNullOrEmpty(tableNumber)) {
            if (StringUtils.isNumeric(tableNumber)) {
                int tableNo = 0;
                try{
                    tableNo = Integer.parseInt(tableNumber);
                } catch (NumberFormatException e) {
                    return ResponseEntity.badRequest().build();
                }
                List<Order> orders = ordersRepository.findAllByTableNumber(tableNo,sort);
                return ResponseEntity.ok(orders);
            }
        }
        List<Order> orders = ordersRepository.findAll(sort);
        return ResponseEntity.ok(orders);
    }

    @GetMapping(path = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrders(@PathVariable("id") String id) {
        Order order = ordersRepository.findOne(id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createOrders(@RequestBody Order order) {
        order.setId(UUID.randomUUID().toString());
        order.setCreatedAt(LocalDateTime.now());
        ordersRepository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PutMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateOrders(@RequestBody Order order) {
        Order orderMongoInstance = ordersRepository.findOne(order.getId());
        if (orderMongoInstance == null) {
            return ResponseEntity.notFound().build();
        }
        orderMongoInstance = order;
        ordersRepository.save(orderMongoInstance);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping(path = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteOrders(@PathVariable("id") String id) {
        Order order = ordersRepository.findOne(id);
        if (order == null){
            return ResponseEntity.notFound().build();
        }
        ordersRepository.delete(id);
        return ResponseEntity.ok(order);
    }


}
