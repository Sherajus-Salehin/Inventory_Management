package com.salehin.ims.service;

import com.salehin.ims.entity.Product;
import com.salehin.ims.entity.Stock;
import com.salehin.ims.entity.StockHistory;
import com.salehin.ims.repository.ProductRepository;
import com.salehin.ims.repository.StockHistoryRepository;
import com.salehin.ims.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public String createStock(Stock s){
        stockRepository.save(s);
        stockHistoryRepository.save(new StockHistory(s.getId(),s.getProduct().getId(),0,s.getQuantity(),"New Stock"));
        return "Stock added successfully: "+s.getName();
    }

    public String stockChange(Long stockId,int quantity,Boolean stockIn){
        Stock s = stockRepository.findById(stockId).orElseThrow(()->new RuntimeException("Stock not found"));
        Integer oldQuantity=s.getQuantity();
        Integer newQuantity=oldQuantity+quantity;
        s.setQuantity(newQuantity);
        stockRepository.save(s);
        stockHistoryRepository.save(new StockHistory(s.getId(),s.getProduct().getId(),oldQuantity,newQuantity,stockIn ? "Stock in" : "Stock out"));
        return "Stock added successfully: "+s.getName();
    }

    public List<StockHistory> getStockHistory(){
        return stockHistoryRepository.findAll();
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name).orElseThrow(()-> new RuntimeException("Product not found"));
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Stock getStockByProductName(String name){
        return stockRepository.findByProductName(name).orElseThrow(()-> new RuntimeException("Stock not found"));
    }
}
