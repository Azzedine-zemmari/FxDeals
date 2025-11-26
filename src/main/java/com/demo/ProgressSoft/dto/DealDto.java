package com.demo.ProgressSoft.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class DealDto {
    @NotNull(message="Id must not be null")
    private Long id;

    @NotNull(message="fromCurrency must not be null")
    @Size(min = 3, max=3 , message = "fromCurrencty must be 3 in max")
    private String fromCurrency;

    @NotNull(message="ToCurrency must not be null")
    @Size(min=3,max=3,message="ToCurrency must be 3 in max")
    private String toCurrency;


    private LocalDateTime timestamp;

    @NotNull(message="amount is required")
    private Double amount;

    public DealDto(){

    }

    public DealDto(Long id, String fromCurrency, String toCurrency, LocalDateTime timestamp, Double amount) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
