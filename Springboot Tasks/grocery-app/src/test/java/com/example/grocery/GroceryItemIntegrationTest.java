package com.example.grocery;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.repository.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GroceryItemIntegrationTest {

    @Autowired
    private GroceryItemRepository repo;

    @Test
    void testSaveAndFindItem() {
        GroceryItem item = new GroceryItem();
        item.setName("Bread");
        item.setQuantity(1);
        item.setPrice(20);

        GroceryItem saved = repo.save(item);
        assertNotNull(repo.findById(saved.getId()).orElse(null));
    }
}
