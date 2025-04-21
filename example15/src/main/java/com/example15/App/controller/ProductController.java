package com.example15.App.controller;


import com.example15.App.domain.Product;
import com.example15.App.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    //Product service's object is made before ProductController object
    @Autowired
    ProductService productService;

    //GET http://localhost:8080/product/getProductByName/{name}
    @GetMapping("/getProductByName/{name}")
    public Product getProductByName(@PathVariable ("name") String name) {
        return productService.findByName(name);
    }

    //GET http://localhost:8080/product/getProductsBySku/{sku}
    @GetMapping("getProductsBySku/{sku}")
    public List<Product> getProductBySku(@PathVariable ("sku") String sku) {
        return productService.findBySku(sku);
    }

    //GET http://localhost:8080/product/FindByPrice/{price}
    @GetMapping("FindByPrice/{price}")
    public List<Product> findByPrice(@PathVariable ("price") double price) {
        return productService.findByPrice(price);
    }


    @GetMapping("/findByNameAndPrice")
    //GET http://localhost:8080/product/findByNameOrPrice?name={data}&price={data};
    ////GET http://localhost:8080/product/FindByNameOrPrice?name=White LED Bulb&price=499;
    public List<Product> findByNameAndPrice(@RequestParam("name") String name, @RequestParam("price") Double price)
    {
            return productService.findByNameAndPrice(name, price);
        }
    }

