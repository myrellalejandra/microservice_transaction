package com.example.nttdata.repository;


import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.nttdata.model.Transaction;

import reactor.core.publisher.Flux;


@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String>{
	
	  @Query(value="{ 'accountNumber' : ?0 }")
	  Flux<Transaction> getAllByAccountNumber(Long accountNumber);
	  
	  @Query(value="{ 'dni' : ?0 }")
	  Flux<Transaction> getAllByDni(Long dni);
}
