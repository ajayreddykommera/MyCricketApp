package com.ajay.practice.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
public class Career {

    private int totalScore;
    private int highestScore;
    private int fifties;
    private int hundreds;
    @DBRef
    private List<Team> teamsPlayedWith;

}
