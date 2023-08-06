package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        log.info("Product {} is saved", product.getId());
        return productRepository.save(product);

    }

}
