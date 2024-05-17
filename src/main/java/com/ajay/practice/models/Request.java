package com.ajay.practice.models;

import lombok.Data;

import java.util.List;
@Data
public class Request {
    String teamName;
    List<String> players;
}
