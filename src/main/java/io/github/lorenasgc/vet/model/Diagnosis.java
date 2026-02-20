package io.github.lorenasgc.vet.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "diagnoses")
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "species")
@NoArgsConstructor
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    //Inverse relationship with Species
    @ManyToMany(mappedBy = "possibleDiagnoses")
    @ToString.Exclude
    private Set<Species> species;
}
