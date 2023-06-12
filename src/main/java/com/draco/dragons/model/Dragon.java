package com.draco.dragons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "dragons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Dragon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dragon_id;

    @Column(name = "nome", length = 100)
    @NotNull
    private String name;

    @Column(name = "tipo", length = 100)
    @NotNull
    private String type;

}
