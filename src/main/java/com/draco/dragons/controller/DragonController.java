package com.draco.dragons.controller;

import com.draco.dragons.model.Dragon;
import com.draco.dragons.repository.DragonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dragons")
public class DragonController {

    @Autowired
    DragonRepository dragonRepository;

    @GetMapping
    public ResponseEntity<List<Dragon>> getAllDragons() {
        List<Dragon> dragons = dragonRepository.findAll();
        return ResponseEntity.ok(dragons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dragon> getDragonById(@PathVariable Long id) {
        Dragon dragon = dragonRepository.findById(id).orElse(null);
        if (dragon != null) {
            return ResponseEntity.ok(dragon);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Dragon> createDragon(@RequestBody Dragon dragon) {
        Dragon createdDragon = dragonRepository.save(dragon);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDragon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dragon> updateDragon(@PathVariable Long id, @RequestBody Dragon updatedDragon) {
        Dragon existingDragon = dragonRepository.findById(id).orElse(null);
        if (existingDragon != null) {
            // Update the name parameter if it's not null
            if (updatedDragon.getName() != null) {
                existingDragon.setName(updatedDragon.getName());
            }

            // Update the type parameter if it's not null
            if (updatedDragon.getType() != null) {
                existingDragon.setType(updatedDragon.getType());
            }

            Dragon savedDragon = dragonRepository.save(existingDragon);
            return ResponseEntity.ok(savedDragon);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDragon(@PathVariable Long id) {
        Dragon dragon = dragonRepository.findById(id).orElse(null);
        if (dragon != null) {
            dragonRepository.delete(dragon);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
