package com.apiDemo.service;

import com.apiDemo.model.GroceryItem;

import java.util.List;

public interface GroceryItemService {
    public GroceryItem addGroceryItem(GroceryItem groceryItem);
    public List<GroceryItem> getAllGroceryItems();
    public GroceryItem getGroceryItem(Long id);
    public GroceryItem updateGroceryItem(Long id, GroceryItem groceryItem);
    public String deleteGroceryItem(Long id);
    public GroceryItem updateInventory(Long id, int quantity);
}
