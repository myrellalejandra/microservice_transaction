package com.example.nttdata.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Document(collection = "Transactions")
@RequiredArgsConstructor 
@Data
public class Transaction {
	@Id
	private String idTransaction;
	 private Date date = new Date();
	private String description;
	private Double amount;
	private String type;
	private Long account_number;
	private Long dni;
}


/*
 * Transactions": [
        {
          "date": ISODate("2023-03-01T09:14:00Z"),
          "description": "Deposit",
          "amount": 500.00,
          "type": "credit",
          "account_number": "123456789" 
        },
        {
          "date": ISODate("2023-03-01T09:14:00Z"),
          "description": "Deposit",
          "amount": 500.00,
          "type": "credit",
          "dni": "73619158" 
        }

 * 
 * */
 