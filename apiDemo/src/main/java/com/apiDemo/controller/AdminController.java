package com.apiDemo.controller;


import com.apiDemo.model.GroceryItem;
import com.apiDemo.service.GroceryItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/grocery-items")
public class AdminController {

    private final GroceryItemService groceryItemService;

    public AdminController(GroceryItemService groceryItemService) {
        this.groceryItemService = groceryItemService;
    }

    @PostMapping("/create")
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem groceryItem) {
        return ResponseEntity.ok(groceryItemService.addGroceryItem(groceryItem));
    }

    @GetMapping("/all")
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
        return ResponseEntity.ok(groceryItemService.getAllGroceryItems());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem groceryItem) {
        return ResponseEntity.ok(groceryItemService.updateGroceryItem(id, groceryItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable Long id) {
        groceryItemService.deleteGroceryItem(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/inventory")
    public ResponseEntity<GroceryItem> updateInventory(@PathVariable Long id, @RequestParam int quantity) {
        return ResponseEntity.ok(groceryItemService.updateInventory(id, quantity));
    }
}
