package com.kafkachat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Message {
    private String author;
    private String text;
    private String timestamp;
}
