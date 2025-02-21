package com.fashion.store.controller;

import com.fashion.store.model.ClothingItem;
import com.fashion.store.service.ClothingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clothing-items")
public class ClothingItemController {

    @Autowired
    private ClothingItemService clothingItemService;

    // Create ClothingItem
    @PostMapping
    public ResponseEntity<ClothingItem> createClothingItem(@RequestBody ClothingItem clothingItem) {
        return ResponseEntity.ok(clothingItemService.createClothingItem(clothingItem));
    }

    

    // Get All ClothingItems with Pagination & Sorting
    @GetMapping
    public ResponseEntity<Page<ClothingItem>> getClothingItems(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        return ResponseEntity.ok(clothingItemService.getClothingItems(page, size, sortBy, sortDir));
    }

    // Get ClothingItem by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClothingItem> getClothingItemById(@PathVariable Long id) {
        Optional<ClothingItem> clothingItem = clothingItemService.getClothingItemById(id);
        return clothingItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update ClothingItem
    @PutMapping("/{id}")
    public ResponseEntity<ClothingItem> updateClothingItem(@PathVariable Long id, @RequestBody ClothingItem clothingItemDetails) {
        return ResponseEntity.ok(clothingItemService.updateClothingItem(id, clothingItemDetails));
    }

    // Delete ClothingItem
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothingItem(@PathVariable Long id) {
        clothingItemService.deleteClothingItem(id);
        return ResponseEntity.noContent().build();
    }
}
