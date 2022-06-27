package com.kafkachat.controller;

import com.kafkachat.model.Message;
import com.kafkachat.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class SendController {

    private final ProducerService producerService;

    @PostMapping(value = "/send")
    public void sendMessage(@RequestBody(required = true) Message message) {
        message.setTimestamp(LocalDateTime.now().toString());
        this.producerService.sendMessage(message);
    }

}
