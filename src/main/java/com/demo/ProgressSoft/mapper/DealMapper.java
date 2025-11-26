package com.demo.ProgressSoft.mapper;

import com.demo.ProgressSoft.dto.DealDto;
import com.demo.ProgressSoft.entity.Deal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DealMapper {
    DealDto DealToDealDto(Deal deal);
    Deal DealDtoToDeal(DealDto dealDto);
}
