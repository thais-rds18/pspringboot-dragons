package com.draco.dragons.controller;

import com.draco.dragons.model.Battle;
import com.draco.dragons.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/battles")
public class BattleController {
    private final BattleRepository battleRepository;

    @Autowired
    public BattleController(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }

    @GetMapping
    public ResponseEntity<List<Battle>> getAllBattles() {
        List<Battle> battles = battleRepository.findAll();
        return ResponseEntity.ok(battles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Battle> getBattleById(@PathVariable Long id) {
        Battle battle = battleRepository.findById(id).orElse(null);
        if (battle != null) {
            return ResponseEntity.ok(battle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Battle> createBattle(@RequestBody Battle battle) {
        Battle createdBattle = battleRepository.save(battle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBattle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Battle> updateBattle(@PathVariable Long id, @RequestBody Battle battle) {
        Battle existingBattle = battleRepository.findById(id).orElse(null);
        if (existingBattle != null) {
            existingBattle.setDuration(battle.getDuration());
            existingBattle.setDragon(battle.getDragon());
            existingBattle.setTrainer(battle.getTrainer());
            Battle updatedBattle = battleRepository.save(existingBattle);
            return ResponseEntity.ok(updatedBattle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBattle(@PathVariable Long id) {
        Battle battle = battleRepository.findById(id).orElse(null);
        if (battle != null) {
            battleRepository.delete(battle);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}