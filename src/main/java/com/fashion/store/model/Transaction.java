package com.fashion.store.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long clothingItemId;

    @JsonFormat(pattern = "yyyy-MM-dd") // Fix for JSON serialization
    private LocalDate transactionDate;

    private Double transactionAmount;

    // Constructors
    public Transaction() {}

    public Transaction(Long userId, Long clothingItemId, LocalDate transactionDate, Double transactionAmount) {
        this.userId = userId;
        this.clothingItemId = clothingItemId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getClothingItemId() {
        return clothingItemId;
    }

    public void setClothingItemId(Long clothingItemId) {
        this.clothingItemId = clothingItemId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
