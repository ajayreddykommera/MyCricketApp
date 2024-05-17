package com.ajay.practice.DTO;

import com.ajay.practice.models.StatusCodeAndMessage;
import com.ajay.practice.models.Team;
import com.ajay.practice.models.output.TeamRes;
import com.ajay.practice.utils.Constants;
import org.springframework.stereotype.Component;

@Component
public class TeamToTeamResDTO {

    public TeamRes convert(Team team) {
        return doConvert(team);
    }

    private TeamRes doConvert(Team team) {
        TeamRes teamRes = new TeamRes();
        teamRes.setTeamName(team.getTeamName());
        teamRes.setTeamId(team.getTeamId());
        StatusCodeAndMessage statusCodeAndMessage = new StatusCodeAndMessage();
        statusCodeAndMessage.setCode(Constants.SUCCESS_CODE);
        statusCodeAndMessage.setMessage("Team Created SuccessFully");
        teamRes.setStatusCodeAndMessage(statusCodeAndMessage);
        return teamRes;
    }
}
