package com.ajay.practice.DTO;

import com.ajay.practice.models.Career;
import com.ajay.practice.models.Player;
import com.ajay.practice.models.StatusCodeAndMessage;
import com.ajay.practice.models.Team;
import com.ajay.practice.models.output.PlayerResponse;
import com.ajay.practice.utils.Constants;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerToPlayerResDTO {

    public PlayerResponse convert(Player player) {
        return doConvert(player);
    }

    private PlayerResponse doConvert(Player player) {

        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setPlayerId(player.getPlayerId());
        playerResponse.setAge(player.getAge());
        playerResponse.setBirthCity(player.getBirthCity());
        playerResponse.setFirstName(player.getFirstName());
        playerResponse.setLastName(player.getLastName());
        Career career = new Career();
        career.setTotalScore(player.getCareer().getTotalScore());
        career.setHighestScore(player.getCareer().getHighestScore());
        career.setFifties(player.getCareer().getFifties());
        career.setHundreds(player.getCareer().getHundreds());
        career.setTeamsPlayedWith(player.getCareer().getTeamsPlayedWith());
        StatusCodeAndMessage statusCodeAndMessage = new StatusCodeAndMessage();
        statusCodeAndMessage.setCode(Constants.SUCCESS_CODE);
        statusCodeAndMessage.setMessage("Player Created SuccessFully");
        playerResponse.setStatusCodeAndMessage(statusCodeAndMessage);
        playerResponse.setCareer(career);

        return playerResponse;
    }
}
