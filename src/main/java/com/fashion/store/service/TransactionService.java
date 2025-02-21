package com.fashion.store.service;

import com.fashion.store.model.Transaction;
import com.fashion.store.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Create a transaction
    public Transaction createTransaction(Transaction transaction) {
        transaction.setTransactionDate(LocalDate.now()); // Set current date if not provided
        return transactionRepository.save(transaction);
    }

    // Bulk Insert Transactions
    public List<Transaction> addTransactions(List<Transaction> transactions) {
        return transactionRepository.saveAll(transactions);
    }

    // Get all transactions with Pagination & Sorting
    public Page<Transaction> getTransactions(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return transactionRepository.findAll(PageRequest.of(page, size, sort));
    }

    // Get a transaction by ID
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    // Update a transaction
    public Transaction updateTransaction(Long id, Transaction transactionDetails) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        transaction.setUserId(transactionDetails.getUserId());
        transaction.setClothingItemId(transactionDetails.getClothingItemId());
        transaction.setTransactionDate(transactionDetails.getTransactionDate());
        transaction.setTransactionAmount(transactionDetails.getTransactionAmount());

        return transactionRepository.save(transaction);
    }

    // Delete a transaction
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
