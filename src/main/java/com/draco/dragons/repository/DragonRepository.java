package com.draco.dragons.repository;

import com.draco.dragons.model.Dragon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DragonRepository extends JpaRepository<Dragon, Long> {
}
