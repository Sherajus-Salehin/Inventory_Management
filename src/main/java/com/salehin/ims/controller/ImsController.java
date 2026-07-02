package com.salehin.ims.controller;

import com.salehin.ims.entity.Product;
import com.salehin.ims.entity.Stock;
import com.salehin.ims.entity.StockHistory;
import com.salehin.ims.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class ImsController {
    @Autowired
    StockService stockService;

    @PostMapping("/createStock")
    public String createStock(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

    @PostMapping("/createProduct")
    public String createProduct(@RequestBody Product product) {
        return stockService.addProduct(product);
    }

    @PostMapping("/stockIn")
    public String stockIn(@RequestBody Stock stock) {
        return stockService.stockChange(stock.getId(), stock.getQuantity(), true);
    }
    @PostMapping("/stockOut")
    public String stockOut(@RequestBody Stock stock) {
        return stockService.stockChange(stock.getId(), stock.getQuantity(), false);
    }

    @GetMapping("/products/{name}")
    public Product getProduct(@PathVariable String name) {
        return stockService.getProductByName(name);
    }
    @GetMapping("/products")
    public List<Product> getProducts() {
        return stockService.getAllProducts();
    }
    @GetMapping("/stock/{productName}")
    public Stock getStock(@PathVariable String productName) {
        return stockService.getStockByProductName(productName);
    }
    @GetMapping("/history")
    public List<StockHistory> getHistory() {
        return stockService.getStockHistory();
    }
}
