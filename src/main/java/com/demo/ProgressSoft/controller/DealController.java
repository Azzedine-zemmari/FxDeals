package com.demo.ProgressSoft.controller;

import com.demo.ProgressSoft.dto.DealDto;
import com.demo.ProgressSoft.entity.Deal;
import com.demo.ProgressSoft.service.DealService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DealController {
    private DealService dealService;
    public DealController(DealService dealService){
        this.dealService = dealService;
    }

    @PostMapping("/deal")
    public ResponseEntity<String> creatDeal(@Valid @RequestBody DealDto importedDeal){
        String deal =  dealService.importDeal(importedDeal);
        return ResponseEntity.ok(deal);
    }
}
