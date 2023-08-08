package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryRequest;
import com.example.inventoryservice.dto.InventoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    List<InventoryResponse> getInventories();

    InventoryResponse getInventory(String id);

    InventoryResponse saveInventory(InventoryRequest inventoryRequest);
}
