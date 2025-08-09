package com.example.clientdemo.controller;

import com.example.clientdemo.entity.Client;
import com.example.clientdemo.repository.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        return "list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("client", new Client());
        return "form";
    }

    @PostMapping
    public String saveClient(@ModelAttribute Client client) {
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Client client = clientRepository.findById(id).orElseThrow();
        model.addAttribute("client", client);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }
}