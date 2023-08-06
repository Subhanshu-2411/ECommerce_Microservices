package com.example.productservice.controller;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> saveProduct(@RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(productService.saveProduct(productRequest), HttpStatus.CREATED);
    }

}
