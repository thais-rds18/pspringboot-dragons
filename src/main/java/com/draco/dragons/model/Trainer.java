package com.draco.dragons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "trainers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainer_id;

    @Column(name = "nome", length = 100)
    @NotNull
    private String name;

    @Column(name = "idade", length = 2)
    @NotNull
    private Integer age;

}
