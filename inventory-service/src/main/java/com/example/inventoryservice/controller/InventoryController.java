package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.InventoryRequest;
import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<InventoryResponse>> getInventories() {
        return new ResponseEntity<>(inventoryService.getInventories(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<InventoryResponse> getInventory(@PathVariable("id") String id) {
        return new ResponseEntity<>(inventoryService.getInventory(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<InventoryResponse> saveInventory(@RequestBody InventoryRequest inventoryRequest) {
        return new ResponseEntity<>(inventoryService.saveInventory(inventoryRequest), HttpStatus.CREATED);
    }

}
