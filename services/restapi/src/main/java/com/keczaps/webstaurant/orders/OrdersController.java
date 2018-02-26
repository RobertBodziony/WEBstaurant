package com.keczaps.webstaurant.orders;

import com.keczaps.webstaurant.order.Order;
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
public class OrdersController {

  private final OrdersService ordersService;

  //    @Secured("ROLE_USER")
  @GetMapping(path = "/orders",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity getOrders(HttpServletRequest httpServletRequest) {
    return ordersService.getOrders(httpServletRequest.getQueryString());
  }

  //    @Secured("ROLE_USER")
  @GetMapping(path = "/orders/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity getOrder(@PathVariable("id") String id) {
    return ordersService.getOrder(id);
  }

  //    @Secured("ROLE_USER")
  @PostMapping(path = "/orders", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
          produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity createOrder(@RequestParam Order order) {
    // TODO - validate order
    return ordersService.createOrder(order);
  }

  //    @Secured("ROLE_USER")
  @PutMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity updateOrder(@RequestParam Order order) {
    // TODO - validate order
    return ordersService.updateOrder(order);
  }

  //    @Secured("ROLE_USER")
  @DeleteMapping(path = "/orders/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  private ResponseEntity deleteOrder(@PathVariable("id") String id) {
    return ordersService.deleteOrder(id);
  }

}
