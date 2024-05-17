package com.ajay.practice.services;

import com.ajay.practice.models.Player;
import com.ajay.practice.models.Team;
import com.ajay.practice.models.input.AddPlayersToTeam;
import com.ajay.practice.models.output.PlayerResponse;
import com.ajay.practice.models.output.TeamRes;


public interface MyCricketService {




    TeamRes addTeam(Team req);

    PlayerResponse addPlayer(Player player);

}

