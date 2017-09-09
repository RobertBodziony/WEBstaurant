package com.keczaps.webstaurant.ingredient;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ingredients")
public class Ingredient {

    @Id
    private String id;

    private String name;

    private Integer price;

    private IngredientType type;

    public enum IngredientType{

        SAUCE("Sos"),
        MEAT("Mięso"),
        VEGETABLE("Warzywa"),
        CHEESE("Ser");

        private String type;

        IngredientType(String type){
            this.type = type;
        }
    }
}
