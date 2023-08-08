package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderResponse saveOrder(OrderRequest orderRequest);

    List<OrderResponse> getOrders();

    OrderResponse getOrder(String id);
}
