package com.sminizen.eco.eco.repository;

import com.sminizen.eco.eco.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    Optional<Products> findByName(String name);
}