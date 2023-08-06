package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Product saveProduct(ProductRequest productRequest);

}
