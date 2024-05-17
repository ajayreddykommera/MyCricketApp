package com.ajay.practice.services.impl;

import com.ajay.practice.DTO.PlayerToPlayerResDTO;
import com.ajay.practice.DTO.TeamToTeamResDTO;
import com.ajay.practice.models.Career;
import com.ajay.practice.models.Player;
import com.ajay.practice.models.Request;
import com.ajay.practice.models.Team;
import com.ajay.practice.models.input.AddPlayersToTeam;
import com.ajay.practice.models.output.PlayerResponse;
import com.ajay.practice.models.output.TeamRes;
import com.ajay.practice.services.MyCricketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyCricketServiceImpl implements MyCricketService {

    private final MongoTemplate myCricketAppTemplate;
    private final TeamToTeamResDTO teamToTeamResDTO;
    private final PlayerToPlayerResDTO playerToPlayerResDTO;

    @Override
    public TeamRes addTeam(Team req) {
        Team team = new Team();
        team.setTeamName(req.getTeamName());
        team.setPlayerId(req.getPlayerId());
        Team response = myCricketAppTemplate.save(team);
        TeamRes teamRes = teamToTeamResDTO.convert(response);
        log.info("Response to controller {}", teamRes);
        return teamRes;
    }

    @Override
    public PlayerResponse addPlayer(Player request) {

        Career career = new Career();
        career.setTotalScore(request.getCareer().getTotalScore());
        career.setHighestScore(request.getCareer().getHighestScore());
        career.setFifties(request.getCareer().getFifties());
        career.setHundreds(request.getCareer().getHundreds());
        career.setTeamsPlayedWith(request.getCareer().getTeamsPlayedWith());
        Player player = new Player();

        player.setAge(request.getAge());
        player.setBirthCity(request.getBirthCity());
        player.setLastName(request.getLastName());
        player.setFirstName(request.getFirstName());
        player.setCareer(career);

        Player response = myCricketAppTemplate.save(player);
        return playerToPlayerResDTO.convert(response);
    }


}
