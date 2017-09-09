package com.keczaps.webstaurant.product;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String[] ingredients;

    private String name;

    private String description;

    private Integer price;

    private ProductType type;

    private Size size;

    public enum ProductType{

        PIZZA("Pizza"),
        DRINK("Drink"),
        PASTA("Pasta"),
        MEAT("Meat");

        private String type;

        ProductType(String type){
            this.type = type;
        }
    }

    private enum Size{

        BABY("Bambino"),
        SMALL("Mały"),
        SENIOR("Senior"),
        MEDIUM("Średni"),
        BIG("Wielki"),
        SUPER_HUNGRY("Super głodny");

        private String type;

        Size(String type){
            this.type = type;
        }
    }




}
