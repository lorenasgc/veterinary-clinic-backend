package io.github.lorenasgc.vet.dto.response;

import java.util.Date;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String role,
        Date createdAt,
        Date updatedAt
) {
}
