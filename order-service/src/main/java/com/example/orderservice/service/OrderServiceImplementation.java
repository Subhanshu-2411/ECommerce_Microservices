package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderResponse saveOrder(OrderRequest orderRequest) {
        Order order = orderRepository.save(Order.builder()
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

        return OrderResponse.builder()
                .Id(order.getId())
                .orderNumber(order.getOrderNumber())
                .orderLineItemsList(order.getOrderLineItemsList())
                .build();
    }

    @Override
    public List<OrderResponse> getOrders() {
        return orderRepository.findAll().stream().map(order -> OrderResponse
                .builder()
                .Id(order.getId())
                .orderNumber(order.getOrderNumber())
                .orderLineItemsList(order.getOrderLineItemsList())
                .build()).toList();
    }

    @Override
    public OrderResponse getOrder(String id) {
        return orderRepository.findById(id).map(order -> OrderResponse
                .builder()
                .Id(order.getId())
                .orderNumber(order.getOrderNumber())
                .orderLineItemsList(order.getOrderLineItemsList())
                .build()).orElse(null);
    }
}
