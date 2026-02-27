package io.github.lorenasgc.vet.controller;

import io.github.lorenasgc.vet.dto.PetOwnerDTO;
import io.github.lorenasgc.vet.service.PetOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pet-owners")
@RequiredArgsConstructor
public class PetOwnerController {

    private final PetOwnerService petOwnerService;

    @GetMapping
    public ResponseEntity<List<PetOwnerDTO>> getAllPetOwners() {
        List<PetOwnerDTO> owners = petOwnerService.findAll();
        return owners.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(owners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetOwnerDTO> getPetOwnerById(@PathVariable Long id) {
        return petOwnerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
