package com.mindtree.transactionJMS.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Transaction 
{
	
	private int transactionId;
	private String from;
	private String to;
	private int amount;
	
	
	public Transaction(int transactionId, String from, String to, int amount) {
		super();
		this.transactionId = transactionId;
		this.from = from;
		this.to = to;
		this.amount = amount;
	}


	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", from=" + from + ", to=" + to + ", amount=" + amount
				+ "]";
	}
	
	
	
	

}
