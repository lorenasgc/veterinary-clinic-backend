package io.github.lorenasgc.vet.controller;

import io.github.lorenasgc.vet.dto.PetDTO;
import io.github.lorenasgc.vet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<PetDTO>> getAllPets() {
        List<PetDTO> pets = petService.findAllPets();
        return pets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(pets);
    }
}
