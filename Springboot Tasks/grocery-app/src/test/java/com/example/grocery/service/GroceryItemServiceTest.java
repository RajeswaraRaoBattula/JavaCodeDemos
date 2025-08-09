package com.example.grocery.service;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.repository.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class GroceryItemServiceTest {

    GroceryItemRepository repo = mock(GroceryItemRepository.class);
    GroceryItemService service = new GroceryItemService(repo);

    @Test
    void testFindAll() {
        when(repo.findAll()).thenReturn(List.of(new GroceryItem()));
        assertEquals(1, service.findAll().size());
    }

    @Test
    void testFindById() {
        GroceryItem item = new GroceryItem();
        item.setId(1L);
        when(repo.findById(1L)).thenReturn(Optional.of(item));
        assertEquals(1L, service.findById(1L).getId());
    }

    @Test
    void testSave() {
        GroceryItem item = new GroceryItem();
        when(repo.save(item)).thenReturn(item);
        assertEquals(item, service.save(item));
    }

    @Test
    void testDelete() {
        service.delete(1L);
        verify(repo).deleteById(1L);
    }
}
