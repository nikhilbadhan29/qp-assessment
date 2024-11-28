package com.apiDemo.service.impl;

import com.apiDemo.model.GroceryItem;
import com.apiDemo.repository.GroceryItemRepository;
import com.apiDemo.service.GroceryItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemServiceImplementation implements GroceryItemService {
    GroceryItemRepository groceryItemRepository;

    public GroceryItemServiceImplementation(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    @Override
    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public GroceryItem getGroceryItem(Long id) {
        return groceryItemRepository.getById(id);
    }

    @Override
    public GroceryItem updateGroceryItem(Long id, GroceryItem groceryItem) {
        GroceryItem existingItem = groceryItemRepository.findById(id).orElseThrow();
        existingItem.setName(groceryItem.getName());
        existingItem.setPrice(groceryItem.getPrice());
        existingItem.setQuantity(groceryItem.getQuantity());
        existingItem.setDescription(groceryItem.getDescription());
        return groceryItemRepository.save(existingItem);
    }

    @Override
    public String deleteGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
        return "Deleted Item";
    }

    @Override
    public GroceryItem updateInventory(Long id, int quantity) {
        GroceryItem existingItem = groceryItemRepository.findById(id).orElseThrow();
        existingItem.setQuantity(quantity);
        return groceryItemRepository.save(existingItem);
    }
}
