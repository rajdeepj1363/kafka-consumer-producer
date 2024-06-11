package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.Entity.User;

@Service
public class KafkaJsonProducer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaJsonProducer.class);
	
	private KafkaTemplate<String, User> kafkaTemplate;

	public KafkaJsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User data)
	{
		logger.info("Message sent : {}",data);
		Message<User> message = MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, "MyJsonTopic")
				.build();
		
		kafkaTemplate.send(message);
	}
}
