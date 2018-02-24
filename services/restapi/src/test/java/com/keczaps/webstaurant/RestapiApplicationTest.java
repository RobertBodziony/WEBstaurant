package com.keczaps.webstaurant;

import com.keczaps.webstaurant.ingredients.IngredientsController;
import com.keczaps.webstaurant.ingredients.IngredientsService;
import com.keczaps.webstaurant.orders.OrdersController;
import com.keczaps.webstaurant.orders.OrdersService;
import com.keczaps.webstaurant.products.ProductsController;
import com.keczaps.webstaurant.products.ProductsService;
import com.keczaps.webstaurant.users.UsersController;
import com.keczaps.webstaurant.users.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestapiApplicationTest {

  @Autowired
  private UsersController usersController;
  @Autowired
  private ProductsController productsController;
  @Autowired
  private OrdersController ordersController;
  @Autowired
  private IngredientsController ingredientsController;
  @Autowired
  private UsersService usersService;
  @Autowired
  private ProductsService productsService;
  @Autowired
  private OrdersService ordersService;
  @Autowired
  private IngredientsService ingredientsService;


  @Test
  public void contextLoads() throws Exception {
    assertThat(usersController).isNotNull();
    assertThat(productsController).isNotNull();
    assertThat(ordersController).isNotNull();
    assertThat(ingredientsController).isNotNull();
    assertThat(usersService).isNotNull();
    assertThat(productsService).isNotNull();
    assertThat(ordersService).isNotNull();
    assertThat(ingredientsService).isNotNull();

  }

}
