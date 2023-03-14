package com.example.nttdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nttdata.model.Transaction;
import com.example.nttdata.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
	}
	
	public List<Transaction> findAll(){
		return transactionRepository.findAll();
	}
	
	public Optional<Transaction> findById(String id) {
		return transactionRepository.findById(id);
	}
	
	public void deleteById(String id) {
		transactionRepository.deleteById(id);
	}

}
