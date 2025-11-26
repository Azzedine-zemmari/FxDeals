package com.demo.ProgressSoft.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dealId;

    @NotNull
    @Size(min = 3, max=3)
    private String fromCurrency;

    @NotNull
    @Size(min=3,max=3)
    private String toCurrency;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    private Double amount;
}
