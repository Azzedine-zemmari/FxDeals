package com.demo.ProgressSoft.validation;

import com.demo.ProgressSoft.exception.InvalidCurrencyException;

import java.util.Currency;

public class CurrencyValidator {
    private CurrencyValidator(){}
    public static void currencyValidate(String currencyCode){
        if(currencyCode == null || currencyCode.isEmpty()){
            throw new IllegalArgumentException("Currency code must not be null");
        }
        try{
            Currency.getInstance(currencyCode.toUpperCase());
        }catch(IllegalArgumentException e){
            throw new InvalidCurrencyException("Invalid Currency code " + currencyCode);
        }
    }
}
