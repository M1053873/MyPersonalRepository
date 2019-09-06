package com.mindtree.demoJMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void send(final String queue,final String message)
	{
		jmsTemplate.convertAndSend(queue,message);
	}

}
