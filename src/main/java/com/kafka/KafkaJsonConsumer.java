package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.Entity.User;

@Service
public class KafkaJsonConsumer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaJsonConsumer.class);
	
	@KafkaListener(topics="MyJsonTopic",groupId="myGroup")
	public void consume(User user)
	{
		logger.info("JSON message received --> {}",user);
	}
}
