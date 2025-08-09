package com.example.grocery.controller;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.service.GroceryItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GroceryItemController.class)
class GroceryItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemService service;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testGetAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(new GroceryItem()));
        mockMvc.perform(get("/api/grocery"))
                .andExpect(status().isOk());
    }

    @Test
    void testCreate() throws Exception {
        GroceryItem item = new GroceryItem();
        item.setName("Milk");
        item.setPrice(25.5);
        item.setQuantity(2);

        when(service.save(any())).thenReturn(item);

        mockMvc.perform(post("/api/grocery")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(item)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Milk"));
    }
}
