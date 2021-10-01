package com.ioco.robot.dto;

import lombok.Data;

@Data
public class Response {
    private String responseCode;
    private String responseMessage;
    private String message;
}
