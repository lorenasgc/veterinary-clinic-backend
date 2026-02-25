package io.github.lorenasgc.vet.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pets")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"owner", "species"})
@NoArgsConstructor
public abstract class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate birthDate;
    private boolean gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "species_id")
    @ToString.Exclude
    private Species species;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    @ToString.Exclude
    private PetOwner owner;

    //The diagnostic method will be specific to each species
    public abstract String getGeneralCheckupGuide();
}
