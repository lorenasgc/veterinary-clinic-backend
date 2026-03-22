package io.github.lorenasgc.vet.controller;

import io.github.lorenasgc.vet.dto.response.PetOwnerDTO;
import io.github.lorenasgc.vet.service.PetOwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet-owners")
@RequiredArgsConstructor
@Validated
@Tag(name = "Pet owners (Clients)", description = "Endpoints for managing pet owners and their contact information")
public class PetOwnerController {

    private final PetOwnerService petOwnerService;

    @Operation(
            summary = "Retrieve all clients",
            description = "Returns a complete list of all registered clients in the clinic. If no clients exist in the database, it returns a No Content status."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of clients retrieved successfully"),
            @ApiResponse(responseCode = "204", description = "No clients found in the database", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden: Missing or invalid JWT token", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<PetOwnerDTO>> getAllPetOwners() {
        List<PetOwnerDTO> owners = petOwnerService.findAll();
        return owners.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(owners);
    }

    @Operation(
            summary = "Retrieve a client by their ID",
            description = "Searches the database for a specific client using their unique identifier."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied (e.g., negative number)", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden: Missing or invalid JWT token", content = @Content),
            @ApiResponse(responseCode = "404", description = "Client not found with the specified ID", content = @Content)
    })
    @GetMapping("/{id}")
    public PetOwnerDTO getPetOwnerById(@Parameter(description = "Client ID", required = true, example = "1") @PathVariable @Min(value = 1, message = "ID must be greater than or equal to 1") Long id) {
        return petOwnerService.findById(id);
    }

}
