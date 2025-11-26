package com.demo.ProgressSoft.service;

import com.demo.ProgressSoft.entity.Deal;
import com.demo.ProgressSoft.repository.DealRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DealService implements DealServiceInterface{
    private final DealRepository dealRepository;
    private static final Logger logger = LoggerFactory.getLogger(DealService.class);

    public DealService(DealRepository dealRepository){
        this.dealRepository = dealRepository;
    }

    @Override
    public String importDeal(Deal deal){
        try{
            if(dealRepository.existsByDealId(deal.getDealId())){
                logger.info("Duplicate deal :" , deal.getDealId());
                return "Deal already imported" + deal.getDealId();
            }
            dealRepository.save(deal);
            logger.info("Deal imported successfully",deal.getDealId());
            return "Deal imported successfully";
        }catch(Exception e){
            logger.error("Erreur importing deal : ",deal.getDealId());
            return "Erreur importing deal : " + deal.getDealId();
        }
    }


}
