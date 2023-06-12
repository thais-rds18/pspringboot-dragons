package com.draco.dragons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "battles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Battle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long battle_id;

    @Column(name = "duracao")
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "dragon_id")
    private Dragon dragon;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;


}
