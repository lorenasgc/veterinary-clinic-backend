package io.github.lorenasgc.vet.service;

import io.github.lorenasgc.vet.dto.DiagnosisDTO;
import io.github.lorenasgc.vet.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private SpeciesRepository speciesRepository;


    @Transactional(readOnly = true)
    public Set<DiagnosisDTO> getPossibleDiagnosesForSpecies(String speciesName) {
        String cleanedName = speciesName.trim().toUpperCase();
        return speciesRepository.findByNameWithDiagnoses(cleanedName)
                .map(species -> species.getPossibleDiagnoses().stream()
                        .map(d -> new DiagnosisDTO(d.getId(), d.getName(), d.getDescription()))
                        .collect(Collectors.toSet()))
                .orElse(Collections.emptySet());
    }
}
