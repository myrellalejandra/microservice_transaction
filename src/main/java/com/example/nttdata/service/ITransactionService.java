package com.example.nttdata.service;

import org.springframework.data.mongodb.repository.Query;

import com.example.nttdata.model.Transaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionService {
	
	public Mono<Transaction> save(Transaction transaction);
	
	public Flux<Transaction> findAll();
	
	public Mono<Transaction> findById(String id);
	
	public void deleteById(String id);
	
	public Flux<Transaction> findByAccountNumber(Long accountNumber);
	
	public Flux<Transaction> findByDni(Long accountNumber);
	
	public  Mono<Transaction> getBalanceByAccount(Long accountNumber);
	  
	public Mono<Transaction> getBalanceByDni(Long dni);

}
