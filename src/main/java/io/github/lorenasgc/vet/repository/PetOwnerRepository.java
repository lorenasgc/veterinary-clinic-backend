package io.github.lorenasgc.vet.repository;

import io.github.lorenasgc.vet.model.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {

    @Query("SELECT p FROM PetOwner p WHERE p.name LIKE %:name%")
    List<PetOwner> findByNameContaining(String name);

    @Query("SELECT DISTINCT po FROM PetOwner po " +
           "LEFT JOIN FETCH po.pets pet " +
           "LEFT JOIN FETCH pet.species " +
           "LEFT JOIN FETCH pet.owner")
    List<PetOwner> findAllWithPets();
}
