package com.draco.dragons.controller;

import com.draco.dragons.model.Trainer;
import com.draco.dragons.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    TrainerRepository trainerRepository;

    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        List<Trainer> trainers = trainerRepository.findAll();
        return ResponseEntity.ok(trainers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
        Trainer trainer = trainerRepository.findById(id).orElse(null);
        if (trainer != null) {
            return ResponseEntity.ok(trainer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
        Trainer createdTrainer = trainerRepository.save(trainer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrainer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable Long id, @RequestBody Trainer trainer) {
        Trainer existingTrainer = trainerRepository.findById(id).orElse(null);
        if (existingTrainer != null) {
            existingTrainer.setName(trainer.getName());
            existingTrainer.setAge(trainer.getAge());
            Trainer updatedTrainer = trainerRepository.save(existingTrainer);
            return ResponseEntity.ok(updatedTrainer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable Long id) {
        Trainer trainer = trainerRepository.findById(id).orElse(null);
        if (trainer != null) {
            trainerRepository.delete(trainer);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
