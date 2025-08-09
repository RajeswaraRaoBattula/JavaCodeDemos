package com.example.grocery.controller;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.service.GroceryItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery")
public class GroceryItemController {

    private final GroceryItemService service;

    public GroceryItemController(GroceryItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<GroceryItem> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GroceryItem getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public GroceryItem create(@Valid @RequestBody GroceryItem item) {
        return service.save(item);
    }

    @PutMapping("/{id}")
    public GroceryItem update(@PathVariable Long id, @Valid @RequestBody GroceryItem item) {
        return service.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
