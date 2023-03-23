package com.example.nttdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nttdata.model.Transaction;
import com.example.nttdata.repository.TransactionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService implements ITransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	public Mono<Transaction> save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public Flux<Transaction> findAll() {
		return transactionRepository.findAll();
	}

	public Mono<Transaction> findById(String id) {
		return transactionRepository.findById(id);
	}

	public void deleteById(String id) {
		transactionRepository.deleteById(id);
	}
	
	public Flux<Transaction> findByAccountNumber(Long accountNumber) {
		return transactionRepository.getAllByAccountNumber(accountNumber);
	}
	
	public Flux<Transaction> findByDni(Long accountNumber) {
		return transactionRepository.getAllByDni(accountNumber);
	}

}
