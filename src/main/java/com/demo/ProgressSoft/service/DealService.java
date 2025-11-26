package com.demo.ProgressSoft.service;

import com.demo.ProgressSoft.entity.Deal;
import com.demo.ProgressSoft.exception.DealAlreadyExistsException;
import com.demo.ProgressSoft.exception.DealInvalidException;
import com.demo.ProgressSoft.repository.DealRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

            if (deal.getDealUniqueId() == null || deal.getDealUniqueId().isEmpty()) {
                deal.setDealUniqueId(generateDealUniquId(deal));
            }

            logger.info("deal" + deal);
            if(dealRepository.existsByDealUniqueId(deal.getDealUniqueId())){
                logger.info("Duplicate deal :" , deal.getDealUniqueId());
                throw new DealAlreadyExistsException("duplicate deal");
            }
            dealRepository.save(deal);
            logger.info("Deal imported successfully",deal.getDealUniqueId());
            return "Deal imported successfully";

    }
    
    public String generateDealUniquId(Deal deal){
        return deal.getFromCurrency() + "-" + deal.getToCurrency() + '-' + deal.getTimestamp().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")) + '-' + String.format("%.2f",deal.getAmount());

    }


}
