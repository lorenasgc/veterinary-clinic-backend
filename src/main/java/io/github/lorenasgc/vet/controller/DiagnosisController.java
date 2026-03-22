package io.github.lorenasgc.vet.controller;

import io.github.lorenasgc.vet.dto.response.DiagnosisDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Diagnoses", description = "Endpoints for managing diagnoses")
public class DiagnosisController {

    private final PetService petService;

    @Operation(
            summary = "Get possible diagnoses for a species",
            description = "Returns a set of all possible medical diagnoses for a given animal species name."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of diagnoses."),
            @ApiResponse(responseCode = "400", description = "Invalid input, the species name cannot be blank.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden: Missing or invalid JWT token.", content = @Content),
    })
    @GetMapping("/species/{speciesName}")
    public Set<DiagnosisDTO> getDiagnosesBySpecies(
            @Parameter(description = "Name of the animal species (e.g., 'Dog', 'Cat')", required = true, example = "Dog")
            @PathVariable @NotBlank String speciesName) {
        return petService.getPossibleDiagnosesForSpecies(speciesName);
    }
}
