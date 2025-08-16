
package com.example.producer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

@RestController
@RequestMapping("/rides")
public class RideController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper = new ObjectMapper();
    private final String TOPIC = "uber-rides";

    public RideController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<?> createRide(@RequestBody Map<String, Object> payload) throws Exception {
        payload.put("operation", "CREATE");
        String json = mapper.writeValueAsString(payload);
        kafkaTemplate.send(TOPIC, json);
        return ResponseEntity.ok(Map.of("status","sent","topic",TOPIC));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRide(@PathVariable String id, @RequestBody Map<String,Object> payload) throws Exception {
        payload.put("operation","UPDATE");
        payload.put("id", id);
        String json = mapper.writeValueAsString(payload);
        kafkaTemplate.send(TOPIC, json);
        return ResponseEntity.ok(Map.of("status","sent","operation","update"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRide(@PathVariable String id) throws Exception {
        Map<String,Object> payload = Map.of("operation","DELETE","id",id);
        String json = mapper.writeValueAsString(payload);
        kafkaTemplate.send(TOPIC, json);
        return ResponseEntity.ok(Map.of("status","sent","operation","delete"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMock(@PathVariable String id) {
        // Producer does not read DB; return mock info
        return ResponseEntity.ok(Map.of("id",id,"message","producer-mock"));
    }
}
