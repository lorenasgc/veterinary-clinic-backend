package io.github.lorenasgc.vet.service;

import io.github.lorenasgc.vet.dto.DiagnosisDTO;
import io.github.lorenasgc.vet.dto.PetDTO;
import io.github.lorenasgc.vet.exception.ResourceNotFoundException;
import io.github.lorenasgc.vet.model.Species;
import io.github.lorenasgc.vet.repository.PetRepository;
import io.github.lorenasgc.vet.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private PetRepository petRepository;

    @Transactional(readOnly = true)
    public Set<DiagnosisDTO> getPossibleDiagnosesForSpecies(String speciesName) {
        String cleanedName = speciesName.trim().toUpperCase();
        Species species = speciesRepository.findByNameWithDiagnoses(cleanedName)
                .orElseThrow(() -> new ResourceNotFoundException("Species not found with name: " + speciesName));
        return species.getPossibleDiagnoses().stream()
                        .map(d -> new DiagnosisDTO(
                                d.getId(),
                                d.getName(),
                                d.getDescription()
                        ))
                        .collect(Collectors.toSet());
    }

    @Transactional(readOnly = true)
    public List<PetDTO> findAllPets() {
        return petRepository.findAll().stream()
                .map(pet -> new PetDTO(
                        pet.getId(),
                        pet.getName(),
                        pet.getBirthDate(),
                        pet.isGender(),
                        pet.getSpecies().getId(),
                        pet.getOwner().getId()
                ))
                .collect(Collectors.toList());
    }
}
