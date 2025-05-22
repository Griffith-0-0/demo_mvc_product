package org.example.demomvcproducts.web;

import org.example.demomvcproducts.entities.Product;
import org.example.demomvcproducts.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestAPI {
    private ProductRepository productRepository;
    public ProductRestAPI(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("/products")
    public List<Product> listProducts() {
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable long id) {
        return productRepository.findById(id).get();
    }
}
