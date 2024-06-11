package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.User;
import com.kafka.KafkaJsonProducer;
import com.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	private KafkaJsonProducer kafkaProducer;

	public JsonMessageController(KafkaJsonProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user)
	{
		kafkaProducer.sendMessage(user);
		return ResponseEntity.ok("JSON message sent to topic");
	}
}
