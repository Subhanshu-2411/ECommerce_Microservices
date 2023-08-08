package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order saveOrder(OrderRequest orderRequest) {
        return orderRepository.save(Order.builder()
                .orderLineItemsList(
                        orderRequest.getOrderLineItemsDtos()
                                .stream()
                                .map(
                                        orderLineItemsDto -> OrderLineItems
                                                .builder()
                                                .skuCode(orderLineItemsDto.getSkuCode())
                                                .quantity(orderLineItemsDto.getQuantity())
                                                .price(orderLineItemsDto.getPrice())
                                                .build()).toList())
                .build());
    }
}
