package com.example.orderservice.dto;

import com.example.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String Id;
    private String orderNumber;
    private List<OrderLineItems> orderLineItemsList;

}
