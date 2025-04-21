package com.example15.App.repository;

import com.example15.App.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //custom query method
    public Product findByName(String name);

    List<Product> findBySku(String sku);

    List<Product> findByPrice(double price);


    List<Product> findByNameAndPrice(String name, Double price);

}
