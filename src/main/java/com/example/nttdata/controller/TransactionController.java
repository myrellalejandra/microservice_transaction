package com.example.nttdata.controller;

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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	private TransactionService service;

	@PostMapping("/transaction")
	public Mono<Transaction> save(@RequestBody Transaction transaction) {
		return service.save(transaction);
	}

	@GetMapping("/transaction")
	public Flux<Transaction> findAll() {
		return service.findAll();
	}

	@GetMapping("/transaction/{id}")
	public Mono<Transaction> findById(@PathVariable String id) {
		return service.findById(id);
	}

	@DeleteMapping("/transaction/{id}")
	public void deleteById(@PathVariable String id) {
		service.deleteById(id);
	}

	@PutMapping("/transaction")
	public void update(@RequestBody Transaction transaction) {
		service.save(transaction);
	}
	
	//get transactions associated accountNumber
	@GetMapping("/getAllByAccountNumber/{accountNumber}")
	public Flux<Transaction> getAllByAccountNumber(@PathVariable Long accountNumber) {
		return service.findByAccountNumber(accountNumber);
	}
	
	//get transactions associated dni - client without account number
	@GetMapping("/getAllByDni/{dni}")
	public Flux<Transaction> getAllByDni(@PathVariable Long dni) {
		return service.findByDni(dni);
	}
}
