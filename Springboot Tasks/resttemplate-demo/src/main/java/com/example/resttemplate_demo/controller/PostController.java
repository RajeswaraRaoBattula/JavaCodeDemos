package com.example.resttemplate_demo.controller;

import com.example.resttemplate_demo.model.Post;
import com.example.resttemplate_demo.service.JsonPlaceholderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consume/posts")
public class PostController {

    private final JsonPlaceholderService service;

    public PostController(JsonPlaceholderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return service.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return service.getPostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return service.createPost(post);
    }

    @PutMapping("/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody Post post) {
        service.updatePost(id, post);
        return "Post updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        service.deletePost(id);
        return "Post deleted successfully!";
    }
}
