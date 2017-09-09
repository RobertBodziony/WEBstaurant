package com.keczaps.webstaurant.userorders;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "userorders")
public class UserOrders {

    @Id
    private String id;

    private String userId;

    private String[] ordersIds;

}
