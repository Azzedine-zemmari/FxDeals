package com.demo.ProgressSoft.service;

import com.demo.ProgressSoft.entity.Deal;
import com.demo.ProgressSoft.exception.DealAlreadyExistsException;
import com.demo.ProgressSoft.exception.DealInvalidException;
import com.demo.ProgressSoft.repository.DealRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DealService implements DealServiceInterface{
    private final DealRepository dealRepository;
    private static final Logger logger = LoggerFactory.getLogger(DealService.class);

    public DealService(DealRepository dealRepository){
        this.dealRepository = dealRepository;
    }

    @Override
    public String importDeal(Deal deal){
            if (deal.getTimestamp() == null) {
                deal.setTimestamp(LocalDateTime.now());
            }
            if (deal.getId() == null) {
               logger.error("You have to insert the id ");
            }
            if(dealRepository.existsById(deal.getId())){
                logger.info("Duplicate deal :" , deal.getId());
                throw new DealAlreadyExistsException("duplicate deal");
            }
            dealRepository.save(deal);
            logger.info("Deal imported successfully",deal.getId());
            return "Deal imported successfully";

    }
    
//    public String generateDealUniquId(Deal deal){
//        return deal.getFromCurrency() + "-" + deal.getToCurrency() + '-' + deal.getTimestamp().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")) + '-' + String.format("%.2f",deal.getAmount());
//
//    }




}
