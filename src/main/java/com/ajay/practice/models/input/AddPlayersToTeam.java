package com.ajay.practice.models.input;

import lombok.Data;

import java.util.List;

@Data
public class AddPlayersToTeam {
    private String teamId;
    private List<String> playerIds;
}
