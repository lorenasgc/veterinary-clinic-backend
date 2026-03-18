package io.github.lorenasgc.vet.controller;

import io.github.lorenasgc.vet.dto.response.PetOwnerDTO;
import io.github.lorenasgc.vet.service.PetOwnerService;
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
public class PetOwnerController {

    private final PetOwnerService petOwnerService;

    @GetMapping
    public ResponseEntity<List<PetOwnerDTO>> getAllPetOwners() {
        List<PetOwnerDTO> owners = petOwnerService.findAll();
        return owners.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(owners);
    }

    @GetMapping("/{id}")
    public PetOwnerDTO getPetOwnerById(@PathVariable @Min(1) Long id) {
        return petOwnerService.findById(id);
    }

}
