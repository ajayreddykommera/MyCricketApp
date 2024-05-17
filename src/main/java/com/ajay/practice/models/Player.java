package com.ajay.practice.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "players")
@Data
public class Player {
    @Id
    private String playerId;
    private String firstName;
    private String lastName;
    private int age;
    private Career career;
    private String birthCity;

}
