package com.example.grocery.service;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.repository.GroceryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    private final GroceryItemRepository repository;

    public GroceryItemService(GroceryItemRepository repository) {
        this.repository = repository;
    }

    public List<GroceryItem> findAll() {
        return repository.findAll();
    }

    public GroceryItem findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public GroceryItem save(GroceryItem item) {
        return repository.save(item);
    }

    public GroceryItem update(Long id, GroceryItem item) {
        GroceryItem existing = repository.findById(id).orElseThrow();
        existing.setName(item.getName());
        existing.setQuantity(item.getQuantity());
        existing.setPrice(item.getPrice());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
