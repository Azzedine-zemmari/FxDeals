package com.demo.ProgressSoft.unit;

import com.demo.ProgressSoft.dto.DealDto;
import com.demo.ProgressSoft.entity.Deal;
import com.demo.ProgressSoft.exception.DealAlreadyExistsException;
import com.demo.ProgressSoft.exception.DealInvalidException;
import com.demo.ProgressSoft.exception.InvalidCurrencyException;
import com.demo.ProgressSoft.mapper.DealMapper;
import com.demo.ProgressSoft.repository.DealRepository;
import com.demo.ProgressSoft.service.DealService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DealServiceTest {
    @Mock
    private DealRepository dealRepository;

    @Mock
    private DealMapper dealMapper;

    @InjectMocks
    private DealService dealService;

    @Test
    public void testImportDeal_Success(){

        DealDto dto = new DealDto();
        dto.setId(1L);
        dto.setAmount(220.1);
        dto.setTimestamp(LocalDateTime.now());
        dto.setFromCurrency("USD");
        dto.setToCurrency("EUR");

        //mock mapping
        Deal deal = new Deal();
        deal.setId(dto.getId());
        deal.setAmount(dto.getAmount());
        deal.setTimestamp(dto.getTimestamp());
        deal.setFromCurrency(dto.getFromCurrency());
        deal.setToCurrency(dto.getToCurrency());

        when(dealMapper.DealDtoToDeal(dto)).thenReturn(deal);
        when(dealRepository.existsById(deal.getId())).thenReturn(false);

        String result = dealService.importDeal(dto);

        verify(dealRepository).save(deal);
        assertEquals("Deal imported successfully" , result);
    }
    @Test
    public void testImportDeal_idNull_throwsDealInvalidException(){
        DealDto dto = new DealDto();
        dto.setId(null);
        dto.setAmount(220.1);
        dto.setTimestamp(LocalDateTime.now());
        dto.setFromCurrency("USD");
        dto.setToCurrency("EUR");

        assertThrows(DealInvalidException.class , ()-> dealService.importDeal(dto));
    }


    @Test
    public void testImportDeal_idAlreadyExists_throwsDealAlreadyExisitsException(){
        DealDto dto = new DealDto();
        dto.setId(2L);
        dto.setAmount(220.1);
        dto.setTimestamp(LocalDateTime.now());
        dto.setFromCurrency("USD");
        dto.setToCurrency("EUR");

        when(dealRepository.existsById(2L)).thenReturn(true);
        assertThrows(DealAlreadyExistsException.class,()-> dealService.importDeal(dto));
    }

    @Test
    public void testImportDeal_CurrencyValidator_throwsInvalidCurrencyException(){
        DealDto dto = new DealDto();
        dto.setId(2L);
        dto.setAmount(220.1);
        dto.setTimestamp(LocalDateTime.now());
        dto.setFromCurrency("XYZ");
        dto.setToCurrency("EUR");

        assertThrows(InvalidCurrencyException.class , ()-> dealService.importDeal(dto));
    }
    @Test
    public void testImportDeal_SameCurrency_thorwsInvalidCurrencyException(){
        DealDto dto = new DealDto();
        dto.setId(2L);
        dto.setTimestamp(LocalDateTime.now());
        dto.setFromCurrency("USD");
        dto.setToCurrency("USD");
        dto.setAmount(300.2);

        assertThrows(InvalidCurrencyException.class, ()-> dealService.importDeal(dto));

    }
    @Test
    public void testImportDeal_NegativeAmout_throwsDealInvalidException(){
        DealDto dto = new DealDto();
        dto.setId(2L);
        dto.setTimestamp(LocalDateTime.now());
        dto.setFromCurrency("USD");
        dto.setToCurrency("EUR");
        dto.setAmount(-300.2);

        assertThrows(DealInvalidException.class,()-> dealService.importDeal(dto));
    }
}
