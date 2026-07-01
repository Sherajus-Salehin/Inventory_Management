package com.salehin.ims.service;

import com.salehin.ims.entity.Product;
import com.salehin.ims.repository.ProductRepository;
import com.salehin.ims.repository.StockHistoryRepository;
import com.salehin.ims.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    StockHistoryRepository stockHistoryRepository;


    public String addProduct(Product p){
        productRepository.save(p);
        return "Product added successfully: "+p.getName();
    }
}
