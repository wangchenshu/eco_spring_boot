package com.sminizen.eco.eco.controller;

import com.sminizen.eco.eco.model.*;
import com.sminizen.eco.eco.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ChatfuelProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/chatfuel/products/{id}")
    public ResponseEntity<ChatfuelMessages> showByRandWords(@PathVariable(value = "id") int id) {
        List<ChatfuelText> chatfuelTexts = new ArrayList<>();
        StringBuilder detailStringBuilder = new StringBuilder();
        Optional<Products> productsOptional = productsService.findById(id);

        productsOptional.ifPresent(products -> {
            String productName = "名稱: " + products.getName() + "\n";
            String productPrice = "價格: " + products.getPrice() + "\n";
            String productPoint = "PV: " + products.getPoint() + "\n";

            detailStringBuilder.append(productName);
            detailStringBuilder.append(productPrice);
            detailStringBuilder.append(productPoint);
        });
        chatfuelTexts.add(new ChatfuelText(detailStringBuilder.toString()));

        return ResponseEntity.ok(new ChatfuelMessages(chatfuelTexts));
    }

    @PostMapping("/chatfuel/products/name")
    public ResponseEntity<ChatfuelMessages> showByName(@RequestBody ProductsRequestBody productsRequestBody) {
        List<ChatfuelText> chatfuelTexts = new ArrayList<>();
        StringBuilder detailStringBuilder = new StringBuilder();
        Optional<Products> productsOptional = productsService.findByName(productsRequestBody.getName());

        productsOptional.ifPresent(products -> {
            String productName = "名稱: " + products.getName() + "\n";
            String productPrice = "價格: " + products.getPrice() + "\n";
            String productPoint = "PV: " + products.getPoint() + "\n";

            detailStringBuilder.append(productName);
            detailStringBuilder.append(productPrice);
            detailStringBuilder.append(productPoint);
        });
        chatfuelTexts.add(new ChatfuelText(detailStringBuilder.toString()));

        return ResponseEntity.ok(new ChatfuelMessages(chatfuelTexts));
    }
}
