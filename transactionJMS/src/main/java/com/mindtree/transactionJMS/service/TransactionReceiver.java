package com.mindtree.transactionJMS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.mindtree.transactionJMS.entity.Transaction;

@Component
public class TransactionReceiver 
{
	
	
	@JmsListener(destination="TransactionQueue")
	public void messageReceiver(String transaction)
	{
		System.out.println(transaction);
		
		System.out.println("received");
	}

}
