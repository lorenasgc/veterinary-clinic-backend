package io.github.lorenasgc.vet.repository;

import io.github.lorenasgc.vet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    //Find by pet name, for example, "Alex"
    List<Pet> findByNameContainingIgnoreCase(String name);

    //Find by species, for example, "Dog"
    List<Pet> findBySpeciesName(String speciesName);

    /**
     * Fetches all pets and eagerly loads their species and owner relationships
     * to prevent the N+1 query problem.
     */
    @Query("SELECT p FROM Pet p LEFT JOIN FETCH p.species LEFT JOIN FETCH p.owner")
    List<Pet> findAllWithDetails();
}
