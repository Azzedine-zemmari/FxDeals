package com.demo.ProgressSoft.unit;

import com.demo.ProgressSoft.entity.Deal;
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

    @InjectMocks
    private DealService dealService;

//    @Test
//    public void testImportDeal_Success(){
//
//        Deal deal = new Deal();
//        deal.setId(1L);
//        deal.setAmount(220.1);
//        deal.setTimestamp(LocalDateTime.now());
//        deal.setFromCurrency("USA");
//        deal.setToCurrency("EUR");
//
//        when(dealRepository.existsById(deal.getId())).thenReturn(false);
//        when(dealRepository.save(any(Deal.class))).thenReturn(deal);
//
//        String result = dealService.importDeal(deal);
//
//        assertEquals("Deal imported successfully" , result);
//        verify(dealRepository,times(1)).save(deal);
//    }
//    public void testImportDeal_

}
