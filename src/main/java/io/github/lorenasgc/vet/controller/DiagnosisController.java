package io.github.lorenasgc.vet.controller;

import io.github.lorenasgc.vet.dto.response.DiagnosisDTO;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
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
@Validated
public class DiagnosisController {

    private final PetService petService;

    @GetMapping("/species/{speciesName}")
    public Set<DiagnosisDTO> getDiagnosesBySpecies(@PathVariable @NotBlank String speciesName) {
        return petService.getPossibleDiagnosesForSpecies(speciesName);
    }
}
