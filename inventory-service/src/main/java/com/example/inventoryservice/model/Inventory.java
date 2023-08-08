package com.example.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "inventory")
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    private String id;
    private String skuCode;
    private Integer quantity;

}
