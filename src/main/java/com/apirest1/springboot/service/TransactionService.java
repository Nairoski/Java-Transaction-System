package com.apirest1.springboot.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import com.apirest1.springboot.model.Transaction;

@Service
public class TransactionService {

	private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();
	
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
		System.out.println(transactions.size());
	}
	
	public void clearTransactions() {
		transactions.clear();
	}
	
	public DoubleSummaryStatistics getStatistics() {
		System.out.println(transactions.size());
		OffsetDateTime now = OffsetDateTime.now();
		return transactions.stream()
//				.filter(t -> t.getDataHora()
//				.isAfter(now.minusSeconds(60)))
				.mapToDouble(Transaction::getValor)
				.summaryStatistics();
	}
	
}
