package com.example.nttdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.nttdata.model.Transaction;


@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String>{
}
