package com.salehin.ims.entity;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Long stockId;
    private Integer oldQuantity;
    private Integer newQuantity;
    private String action;
    @CreationTimestamp
    private LocalDateTime actionDate;

    public StockHistory(Long id, Long id1, Integer oldQuantity, Integer newQuantity, String action) {
        stockId = id;
        productId = id1;
        this.oldQuantity = oldQuantity;
        this.newQuantity = newQuantity;
        this.action = action;
    }
}
