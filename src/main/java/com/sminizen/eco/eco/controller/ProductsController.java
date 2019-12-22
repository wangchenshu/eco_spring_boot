package com.sminizen.eco.eco.controller;

import com.sminizen.eco.eco.model.ChatfuelMessages;
import com.sminizen.eco.eco.model.ChatfuelText;
import com.sminizen.eco.eco.model.Products;
import com.sminizen.eco.eco.model.ProductsRequestBody;
import com.sminizen.eco.eco.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/products")
    public ResponseEntity<List<Products>> showAll() {
        return new ResponseEntity<>(productsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Products> showById(@PathVariable(value = "id") int id) {
        System.out.println("id = " + id);
        return productsService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<Products> showByName(@PathVariable(value = "name") String name) {
        System.out.println("name = " + name);
        return productsService.findByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().body(null));
    }
}
