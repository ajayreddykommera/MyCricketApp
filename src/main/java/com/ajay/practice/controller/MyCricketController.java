package com.ajay.practice.controller;

import com.ajay.practice.models.Player;
import com.ajay.practice.models.StatusCodeAndMessage;
import com.ajay.practice.models.Team;
import com.ajay.practice.models.output.PlayerResponse;
import com.ajay.practice.models.output.TeamRes;
import com.ajay.practice.services.MyCricketService;
import com.ajay.practice.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyCricketController {

    private final MyCricketService myCricketService;

    @PostMapping("/addTeam")
    public ResponseEntity<TeamRes> createTeam(@RequestBody Team request) {
        TeamRes response = new TeamRes();
        if (request == null) {
            StatusCodeAndMessage statusCodeAndMessage = new StatusCodeAndMessage();
            statusCodeAndMessage.setCode(Constants.ERROR_CODE);
            statusCodeAndMessage.setMessage("request is null");
            response.setStatusCodeAndMessage(statusCodeAndMessage);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        response = myCricketService.addTeam(request);
        if (response != null && response.getStatusCodeAndMessage().getCode() == Constants.ERROR_CODE) {
            StatusCodeAndMessage statusCodeAndMessage = new StatusCodeAndMessage();
            statusCodeAndMessage.setCode(response.getStatusCodeAndMessage().getCode());
            statusCodeAndMessage.setMessage(response.getStatusCodeAndMessage().getMessage());
            response.setStatusCodeAndMessage(statusCodeAndMessage);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/addPlayer")
    public ResponseEntity<PlayerResponse> addPlayer(@RequestBody Player request) {

        PlayerResponse response = new PlayerResponse();
        if (request == null) {
            StatusCodeAndMessage statusCodeAndMessage = new StatusCodeAndMessage();
            statusCodeAndMessage.setCode(Constants.ERROR_CODE);
            statusCodeAndMessage.setMessage("request is null");
            response.setStatusCodeAndMessage(statusCodeAndMessage);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        response = myCricketService.addPlayer(request);
        if (response != null && response.getStatusCodeAndMessage().getCode() == Constants.ERROR_CODE) {
            StatusCodeAndMessage statusCodeAndMessage = new StatusCodeAndMessage();
            statusCodeAndMessage.setCode(response.getStatusCodeAndMessage().getCode());
            statusCodeAndMessage.setMessage(response.getStatusCodeAndMessage().getMessage());
            response.setStatusCodeAndMessage(statusCodeAndMessage);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


}
