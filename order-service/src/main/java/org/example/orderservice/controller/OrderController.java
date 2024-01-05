package org.example.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.orderservice.service.KafkaSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.ordercommon.model.OrderEvent;
import org.example.ordercommon.model.Order;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class OrderController {

    private final KafkaSenderService kafkaSenderService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Order message) {
        kafkaSenderService.send(OrderEvent.fromOrder(message));
        return ResponseEntity.ok("Message send to kafka");
    }
}
