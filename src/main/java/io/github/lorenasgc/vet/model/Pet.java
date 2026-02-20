package io.github.lorenasgc.vet.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "pets")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public abstract class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate birthDate;
    private boolean gender;

    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;

    //El método de diagnóstico será específico para cada animal
    public abstract String getGeneralCheckupGuide();



}
