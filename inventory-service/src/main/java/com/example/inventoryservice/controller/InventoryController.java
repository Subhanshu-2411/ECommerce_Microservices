package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.InventoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<InventoryResponse>> getInventory() {
        return null;
    }
}
