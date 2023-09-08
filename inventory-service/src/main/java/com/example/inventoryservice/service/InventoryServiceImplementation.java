package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryRequest;
import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImplementation implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public List<InventoryResponse> getInventories() {
        return inventoryRepository.findAll().stream().map(inventory -> InventoryResponse
                .builder()
                .id(inventory.getId())
                .skuCode(inventory.getSkuCode())
                .quantity(inventory.getQuantity())
                .build()
        ).toList();
    }

    @Override
    public InventoryResponse getInventory(String id) {
        return inventoryRepository.findById(id).map(inventory -> InventoryResponse
                        .builder()
                        .id(inventory.getId())
                        .skuCode(inventory.getSkuCode())
                        .quantity(inventory.getQuantity())
                        .build()
        ).orElse(null);
    }

    @Override
    public InventoryResponse saveInventory(InventoryRequest inventoryRequest) {
        Inventory inventory = inventoryRepository.save(Inventory.builder()
                .skuCode(inventoryRequest.getSkuCode())
                .quantity(inventoryRequest.getQuantity())
                .build()
        );
        return InventoryResponse.builder()
                .id(inventory.getId())
                .skuCode(inventory.getSkuCode())
                .quantity(inventory.getQuantity())
                .build();
    }

    @Override
    public InventoryResponse getInventoryBySkuCode(String skuCode) {
        Inventory inventory = inventoryRepository.findAll().stream().filter(object -> object.getSkuCode().equals(skuCode)).findFirst().get();

        return InventoryResponse.builder()
                .id(inventory.getId())
                .skuCode(inventory.getSkuCode())
                .quantity(inventory.getQuantity())
                .build();
    }
}
