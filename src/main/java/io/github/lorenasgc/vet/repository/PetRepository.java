package io.github.lorenasgc.vet.repository;

import io.github.lorenasgc.vet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    //Find by pet name, for example, "Alex"
    List<Pet> findByNameContainingIgnoreCase(String name);

    //Find by species, for example, "Dog"
    List<Pet> findBySpeciesName(String speciesName);
}
