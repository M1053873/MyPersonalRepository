package com.mindtree.demoJMS;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@SpringBootApplication
@EnableJms
public class DemoJmsApplication {
	
	 @Bean
	   public JmsListenerContainerFactory<?>
	         jmsListenerContainerFactory
	         (ConnectionFactory connectionFactory,
	          DefaultJmsListenerContainerFactoryConfigurer
	            configurer) {
	      DefaultJmsListenerContainerFactory factory =
	         new DefaultJmsListenerContainerFactory();
	      configurer.configure(factory, connectionFactory);
	      return factory;
	   }

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context =
		SpringApplication.run(DemoJmsApplication.class, args);
		MessageSender sender=context.getBean("messageSender",
		         MessageSender.class);
		      sender.send("msgQueue","Hi! How are you?");
		      context.close();
	}

}
