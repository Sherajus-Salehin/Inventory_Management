package com.salehin.ims.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String sku;
    private double price;
    private boolean active;
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    @JsonManagedReference
    private Stock stock;
}
