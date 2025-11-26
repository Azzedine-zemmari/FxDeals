package com.demo.ProgressSoft.repository;

import com.demo.ProgressSoft.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<Deal,Long> {
    boolean existsByDealUniqueId(String dealUniqueId);
}
