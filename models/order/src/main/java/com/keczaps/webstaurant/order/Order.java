package com.keczaps.webstaurant.order;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Document(collection = "order")
public class Order {

    @Id
    private String id;

    private String[] products;

    private Integer tableNumber;

    private Integer price;

    @CreatedDate
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;

    private State state;

    private String clientNotes;

    public enum State{

        UNCONFIRMED("Unconfirmed"),
        CONFIRMED("Confirmed"),
        IN_PROGRESS("In_progress"),
        READY_TO_SERVE("Ready_to_serve"),
        SERVED("Served"),
        COMPLETED("Completed");

        private String state;

        State(String state){
            this.state = state;
        }
    }
}
