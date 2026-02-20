package io.github.lorenasgc.vet.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "species")
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"pets", "possibleDiagnoses"})
@NoArgsConstructor
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name; // Example: "Dog", "Cat"

    // Relationship with Pet: one type has many pets
    @OneToMany(mappedBy = "species")
    @ToString.Exclude
    private List<Pet> pets;

    @ManyToMany
    @JoinTable(
            name = "species_diagnoses", // Name of the pivot table
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "diagnosis_id")
    )
    @ToString.Exclude
    private Set<Diagnosis> possibleDiagnoses;
}
