package io.github.lorenasgc.vet.service;

import io.github.lorenasgc.vet.dto.response.DiagnosisDTO;
import io.github.lorenasgc.vet.dto.response.PetDTO;
import io.github.lorenasgc.vet.exception.ResourceNotFoundException;
import io.github.lorenasgc.vet.mapper.DiagnosisMapper;
import io.github.lorenasgc.vet.mapper.PetMapper;
import io.github.lorenasgc.vet.model.Species;
import io.github.lorenasgc.vet.repository.PetRepository;
import io.github.lorenasgc.vet.repository.SpeciesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

    private final SpeciesRepository speciesRepository;
    private final PetRepository petRepository;
    private final DiagnosisMapper diagnosisMapper;
    private final PetMapper petMapper;

    @Transactional(readOnly = true)
    public Set<DiagnosisDTO> getPossibleDiagnosesForSpecies(String speciesName) {
        String cleanedName = speciesName.trim().toUpperCase();
        Species species = speciesRepository.findByNameWithDiagnoses(cleanedName)
                .orElseThrow(() -> new ResourceNotFoundException("Species not found with name: " + speciesName));

        return species.getPossibleDiagnoses().stream()
                .map(diagnosisMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Transactional(readOnly = true)
    public List<PetDTO> findAllPets() {
        return petRepository.findAllWithDetails().stream()
                .map(petMapper::toDto)
                .collect(Collectors.toList());
    }
}
