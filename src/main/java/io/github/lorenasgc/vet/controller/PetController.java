package io.github.lorenasgc.vet.controller;

import io.github.lorenasgc.vet.dto.response.PetDTO;
import io.github.lorenasgc.vet.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
@Validated
@Tag(name = "Pets (Patients)", description = "Endpoints for managing pets")
public class PetController {

    private final PetService petService;

    @Operation(
            summary = "Get all pets",
            description = "Retrieves a list of all registered pets in the system."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of pets."),
            @ApiResponse(responseCode = "204", description = "No pets found in the system.", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden: Missing or invalid JWT token.", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<PetDTO>> getAllPets() {
        List<PetDTO> pets = petService.findAllPets();
        return pets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(pets);
    }
}
