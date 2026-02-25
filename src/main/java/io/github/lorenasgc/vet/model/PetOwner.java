package io.github.lorenasgc.vet.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "pet_owners")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "pets") // Exclude the collection to avoid infinite loops
public class PetOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pet> pets = new HashSet<>();

}