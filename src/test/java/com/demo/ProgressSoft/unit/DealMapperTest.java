package com.demo.ProgressSoft.unit;

import com.demo.ProgressSoft.dto.DealDto;
import com.demo.ProgressSoft.entity.Deal;
import com.demo.ProgressSoft.mapper.DealMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealMapperTest {
    private final DealMapper dealMapper = Mappers.getMapper(DealMapper.class);
    @Test
    public void TestDtoToEntity(){
        DealDto dto = new DealDto();
        dto.setId(2L);
        dto.setTimestamp(LocalDateTime.now());
        dto.setFromCurrency("USD");
        dto.setToCurrency("EUR");
        dto.setAmount(300.2);

        Deal deal = dealMapper.DealDtoToDeal(dto);

        assertEquals(dto.getId(),deal.getId());
        assertEquals(dto.getAmount(), deal.getAmount());
        assertEquals(dto.getFromCurrency(), deal.getFromCurrency());
        assertEquals(dto.getToCurrency(), deal.getToCurrency());
        assertEquals(dto.getTimestamp(), deal.getTimestamp());
    }

    @Test
    public void TestEntityTODto(){
        Deal deal = new Deal();
        deal.setId(1L);
        deal.setAmount(200.2);
        deal.setTimestamp(LocalDateTime.now());
        deal.setFromCurrency("USD");
        deal.setToCurrency("EUR");

        DealDto dto = dealMapper.DealToDealDto(deal);
        assertEquals(dto.getId(),deal.getId());
        assertEquals(dto.getAmount(), deal.getAmount());
        assertEquals(dto.getFromCurrency(), deal.getFromCurrency());
        assertEquals(dto.getToCurrency(), deal.getToCurrency());
        assertEquals(dto.getTimestamp(), deal.getTimestamp());
    }
}
