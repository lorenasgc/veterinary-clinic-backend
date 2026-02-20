package io.github.lorenasgc.vet.controller;

import io.github.lorenasgc.vet.dto.DiagnosisDTO;
import io.github.lorenasgc.vet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/diagnoses")
public class DiagnosisController {

    @Autowired
    private PetService petService;

    @GetMapping("/species/{speciesName}")
    public ResponseEntity<Set<DiagnosisDTO>> getDiagnosesBySpecies(@PathVariable String speciesName) {
        Set<DiagnosisDTO> diagnoses = petService.getPossibleDiagnosesForSpecies(speciesName);
        return diagnoses.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(diagnoses);
    }
}
