package com.sminizen.eco.eco.service;

import com.sminizen.eco.eco.model.Products;
import com.sminizen.eco.eco.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    public Optional<Products> findById(int id) {
        return productsRepository.findById(id);
    }

    public Optional<Products> findByName(String name) {
        System.out.println("name = " + name);
        return productsRepository.findByName(name);
    }
}
