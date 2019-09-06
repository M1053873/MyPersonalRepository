package com.mindtree.demoJMS;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
	
	@JmsListener(destination = "msgQueue",
		      containerFactory = "jmsListenerContainerFactory")
	public void receiveMessage(String message)
	{
		System.out.println("Message Received\n\n");
		System.out.println("done");
	      System.out.println("Message received from Queue:"+message);
	}

}
