package com.yatharth.smart_road.controller;

import com.yatharth.smart_road.entity.Pothole;
import com.yatharth.smart_road.service.PotholeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/potholes")
@CrossOrigin(origins = "*")
public class PotholeController {

    @Autowired
    private PotholeService potholeService;

    @GetMapping
    public List<Pothole> getAllPotholes() {
        return potholeService.getAllPotholes();
    }

    @GetMapping("/severity/high")
    public List<Pothole> getHighSeverityPotholes() {
        return potholeService.getHighSeverityPotholes();
    }

    @PostMapping
    public Pothole addPothole(@RequestBody Pothole pothole) {
        return potholeService.addPothole(pothole);
    }

    @PatchMapping("/{id}/fix")
    public ResponseEntity<?> markAsFixed(@PathVariable Long id) {
        return potholeService.markAsFixed(id)
            .map(p -> ResponseEntity.ok((Object) p))
            .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/remove-image")
    public ResponseEntity<?> removeImage(@PathVariable Long id) {
        return potholeService.removeImage(id)
            .map(p -> ResponseEntity.ok((Object) p))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePothole(@PathVariable Long id) {
        boolean deleted = potholeService.deletePothole(id);
        if (deleted) {
            return ResponseEntity.ok(Map.of("message", "Pothole report deleted successfully"));
        }
        return ResponseEntity.notFound().build();
    }
}