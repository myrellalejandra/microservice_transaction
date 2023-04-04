package com.example.nttdata.repository;


import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.nttdata.model.Transaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String>{
	
	  @Query(value="{ 'accountNumber' : ?0 }")
	  Flux<Transaction> getAllByAccountNumber(Long accountNumber);
	  
	  @Query(value="{ 'dni' : ?0 }")
	  Flux<Transaction> getAllByDni(Long dni);
	  
	  @Aggregation("{ $match: { accountNumber: ?0 } }, { $sort: { date: -1 } }, { $limit: ?1 }")
	  Mono<Transaction> getBalanceByAccount(Long accountNumber);
	  
	  //cant'use query if I'm going to use  a lot of filters
	  @Aggregation("{ $match: { dni: ?0 } }, { $sort: { date: -1 } }, { $limit: ?1 }")
	  Mono<Transaction> getBalanceByDni(Long dni);

	  

}
