package com.example.nttdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nttdata.model.Transaction;
import com.example.nttdata.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/postTransaction")
	public void save(@RequestBody Transaction transaction) {
		transactionService.save(transaction);
	}
	
	@GetMapping("/transaction")
	public List<Transaction> findAll(){
		return transactionService.findAll();
	}
	
	@GetMapping("/transaction/{id}")
	public Transaction findById(@PathVariable String id){
		return transactionService.findById(id).get();
	}
	
	@DeleteMapping("/transaction/{id}")
	public void deleteById(@PathVariable String id){
		transactionService.deleteById(id);
	}
	
	@PutMapping("/transaction")
	public void update(@RequestBody Transaction transaction){
		transactionService.save(transaction);
	}
}
