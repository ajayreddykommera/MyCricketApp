package com.ajay.practice.models.output;

import com.ajay.practice.models.StatusCodeAndMessage;
import lombok.Data;

@Data
public class TeamRes {
    private String teamId;
    private String teamName;
    private StatusCodeAndMessage statusCodeAndMessage;
}
