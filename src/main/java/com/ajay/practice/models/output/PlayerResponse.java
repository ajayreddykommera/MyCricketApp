package com.ajay.practice.models.output;

import com.ajay.practice.models.Career;
import com.ajay.practice.models.StatusCodeAndMessage;
import lombok.Data;

@Data
public class PlayerResponse {
    private String playerId;
    private String firstName;
    private String lastName;
    private int age;
    private Career career;
    private String birthCity;
    private StatusCodeAndMessage statusCodeAndMessage;
}
