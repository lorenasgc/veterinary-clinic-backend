package io.github.lorenasgc.vet.repository;

import io.github.lorenasgc.vet.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {

    @Query("SELECT s FROM Species s LEFT JOIN FETCH s.possibleDiagnoses WHERE UPPER(s.name) = :name")
    Optional<Species> findByNameWithDiagnoses(@Param("name") String name);

}