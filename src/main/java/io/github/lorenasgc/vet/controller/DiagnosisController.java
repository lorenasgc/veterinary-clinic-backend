package io.github.lorenasgc.vet.controller;

import io.github.lorenasgc.vet.dto.DiagnosisDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import io.github.lorenasgc.vet.service.PetService;

import java.util.Set;

@RestController
@RequestMapping("/api/diagnoses")
@RequiredArgsConstructor
public class DiagnosisController {

    private final PetService petService;

    @GetMapping("/species/{speciesName}")
    public ResponseEntity<Set<DiagnosisDTO>> getDiagnosesBySpecies(@PathVariable String speciesName) {
        Set<DiagnosisDTO> diagnoses = petService.getPossibleDiagnosesForSpecies(speciesName);
        return diagnoses.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(diagnoses);
    }
}
