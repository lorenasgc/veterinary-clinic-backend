package io.github.lorenasgc.vet.dto.response;

import java.time.LocalDate;

public record PetDTO(
    Long id,
    String name,
    LocalDate birthDate,
    boolean gender,
    Long speciesId,
    Long ownerId
) {
}
