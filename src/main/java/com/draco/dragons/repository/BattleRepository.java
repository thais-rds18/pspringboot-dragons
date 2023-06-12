package com.draco.dragons.repository;

import com.draco.dragons.model.Battle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BattleRepository extends JpaRepository<Battle, Long> {
}
