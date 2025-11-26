package com.demo.ProgressSoft.service;

import com.demo.ProgressSoft.dto.DealDto;
import com.demo.ProgressSoft.entity.Deal;
import com.demo.ProgressSoft.exception.DealAlreadyExistsException;
import com.demo.ProgressSoft.exception.DealInvalidException;
import com.demo.ProgressSoft.exception.InvalidCurrencyException;
import com.demo.ProgressSoft.mapper.DealMapper;
import com.demo.ProgressSoft.repository.DealRepository;
import com.demo.ProgressSoft.validation.CurrencyValidator;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Service
public class DealService implements DealServiceInterface{
    private final DealRepository dealRepository;
    private final DealMapper dealMapper;
    private static final Logger logger = LoggerFactory.getLogger(DealService.class);

    public DealService(DealRepository dealRepository,DealMapper dealMapper){
        this.dealRepository = dealRepository;
        this.dealMapper = dealMapper;
    }

    @Override
    public String importDeal(DealDto dealDto){
            if (dealDto.getId() == null) {
               throw new DealInvalidException("id is required");
            }

            if(dealRepository.existsById(dealDto.getId())){
                logger.info("Duplicate deal :" , dealDto.getId());
                throw new DealAlreadyExistsException("duplicated deal");
            }

            CurrencyValidator.currencyValidate(dealDto.getFromCurrency());
            CurrencyValidator.currencyValidate(dealDto.getToCurrency());

            if(dealDto.getFromCurrency().equals(dealDto.getToCurrency())){
                throw new InvalidCurrencyException("From Currency to Currency it can 't be the same");
            }

            Deal deal = dealMapper.DealDtoToDeal(dealDto);
            if(deal.getTimestamp() == null){
                deal.setTimestamp(LocalDateTime.now());
            }

            dealRepository.save(deal);

            logger.info("Deal imported successfully",deal.getId());
            return "Deal imported successfully";

    }

}
