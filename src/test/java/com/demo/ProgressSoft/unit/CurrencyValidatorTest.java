package com.demo.ProgressSoft.unit;

import com.demo.ProgressSoft.exception.InvalidCurrencyException;
import com.demo.ProgressSoft.validation.CurrencyValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CurrencyValidatorTest {
    @Test
    void validCurrencyCode_shouldPass(){
        assertDoesNotThrow(()-> CurrencyValidator.currencyValidate("USD"));
        assertDoesNotThrow(()->CurrencyValidator.currencyValidate("eur"));
    }
    @Test
    void emptyCurrencyCode_shouldThrowIllegalArgumentException(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->CurrencyValidator.currencyValidate(""));
        assertEquals("Currency code must not be null",exception.getMessage());
    }
    @Test
    void invalidCurrencyCode_shouldThrowInvalidCurrencyException(){
        InvalidCurrencyException exception =  assertThrows(InvalidCurrencyException.class,()-> CurrencyValidator.currencyValidate("ABC"));
        assertEquals("Invalid Currency code ABC" ,exception.getMessage());
    }
}
