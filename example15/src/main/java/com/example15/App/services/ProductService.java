package com.example15.App.services;


import com.example15.App.domain.Product;
import com.example15.App.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    //reference to ProductRepository
    @Autowired
    ProductRepository productRepository;

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> findBySku(String sku) {
        return productRepository.findBySku(sku);
    }

    public List<Product> findByPrice(double price) {
        return productRepository.findByPrice(price);
    }

    public List<Product> findByNameAndPrice(String name, Double price) {
        return productRepository.findByNameAndPrice(name, price);
    }

}
