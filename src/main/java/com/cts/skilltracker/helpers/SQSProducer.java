package com.cts.skilltracker.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.cts.skilltracker.models.ProfileRsp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SQSProducer {
	
	private static Logger logger = LoggerFactory.getLogger(SQSProducer.class);
	
	@Autowired
	QueueMessagingTemplate queueMessagingTemplate;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Value("${cloud.aws.end-point.uri}")
	private String endPoint;
	
	public void publish(ProfileRsp user) {
		
		String METHOD = "publish() - ";
		logger.info(METHOD + "Entry -> ProfileRsp:: " + user.toString());
		
		try {
			String jsonString = objectMapper.writeValueAsString(user);
			queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(jsonString).build());
			logger.info(METHOD + "Message sent successfully:: " + jsonString);
		} catch (JsonProcessingException ex) {
			logger.error(METHOD + "Exception occurred:: " + ex.getMessage());
		}
		
	}

}
