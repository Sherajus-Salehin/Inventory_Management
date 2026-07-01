package com.salehin.ims.repository;

import com.salehin.ims.entity.StockHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockHistoryRepository extends JpaRepository<StockHistory,Long> {
}
