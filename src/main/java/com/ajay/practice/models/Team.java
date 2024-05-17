package com.ajay.practice.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "teams")
@Data
public class Team {
    @Id
    private String teamId;
    private String teamName;
    @DBRef
    private List<Player> playerId;

}
