package com.example.resttemplate_demo.service;

import com.example.resttemplate_demo.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class JsonPlaceholderService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    public List<Post> getAllPosts() {
        ResponseEntity<Post[]> response = restTemplate.getForEntity(BASE_URL, Post[].class);
        return Arrays.asList(response.getBody());
    }

    public Post getPostById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Post.class);
    }

    public Post createPost(Post post) {
        return restTemplate.postForObject(BASE_URL, post, Post.class);
    }

    public void updatePost(Long id, Post post) {
        restTemplate.put(BASE_URL + "/" + id, post);
    }

    public void deletePost(Long id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}
