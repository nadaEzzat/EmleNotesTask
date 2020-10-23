package com.example.emlenotestask.model;

public class Messages {
    private String Message;
    private Integer Sender;

    public String getMessage() {
        return Message;
    }


    public Integer getSender() {
        return Sender;
    }


    public Messages(String message, Integer sender) {
        Message = message;
        Sender = sender;
    }
}
