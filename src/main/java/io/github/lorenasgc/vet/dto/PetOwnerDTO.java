package io.github.lorenasgc.vet.dto;

import java.util.Set;

public record PetOwnerDTO(
        Long id,
        String name,
        String email,
        String phone,
        Set<PetDTO> pets
) {
}


