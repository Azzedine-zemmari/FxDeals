package com.demo.ProgressSoft.unit;

import com.demo.ProgressSoft.dto.DealDto;
import com.demo.ProgressSoft.entity.Deal;
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
//    public void testImportDeal_

}
