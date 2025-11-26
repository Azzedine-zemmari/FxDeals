package com.demo.ProgressSoft.service;

import com.demo.ProgressSoft.entity.Deal;
import com.demo.ProgressSoft.repository.DealRepository;
import org.springframework.stereotype.Service;

@Service
public class DealService implements DealServiceInterface{
    private final DealRepository dealRepository;

    public DealService(DealRepository dealRepository){
        this.dealRepository = dealRepository;
    }

    public String importDeal(Deal deal){
        if(dealRepository.existsByDealId(deal.getDealId())){

        }
    }


}
