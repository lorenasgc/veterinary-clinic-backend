package io.github.lorenasgc.vet.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record PetOwnerDTO(
        Long id,

        @NotBlank(message = "Owner name cannot be blank.")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters.")
        String name,

        @NotBlank(message = "Email cannot be blank.")
        @Email(message = "Please provide a valid email address.")
        String email,

        @Pattern(regexp = "^\\+[0-9]{10,15}$", message = "Phone number must start with + and be 10 to 15 digits long.")
        String phone,

        // Triggers validation on each PetDTO inside this Set
        @Valid
        Set<PetDTO> pets
) {
}
