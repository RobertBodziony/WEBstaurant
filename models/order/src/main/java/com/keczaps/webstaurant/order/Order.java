package com.keczaps.webstaurant.order;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "order")
public class Order {

    @Id
    private String id;

    private String[] products;

    private Integer tableNumber;

    @CreatedDate
    private LocalDateTime createdAt;

    private State state;

    private String clientNotes;

    public enum State{

        UNCONFIRMED("Niepotwierdzone"),
        CONFIRMED("Potwierdzone"),
        IN_PROGRESS("W trakcie realizacji"),
        READY_TO_SERVE("Gotowe do wydania"),
        SERVER("Wydane"),
        COMPLETED("Zakończone");

        private String state;

        State(String state){
            this.state = state;
        }
    }
}
