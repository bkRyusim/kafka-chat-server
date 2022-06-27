package com.kafkachat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkachat.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {

    @Value("chat")
    private String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(Message message) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonMessage = objectMapper.writeValueAsString(message);
            this.kafkaTemplate.send(this.topic, jsonMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
