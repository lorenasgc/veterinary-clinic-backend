package io.github.lorenasgc.vet.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateUserRequest(
        @NotBlank(message = "First name cannot be blank.")
        @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters.")
        String firstName,

        @NotBlank(message = "Last name cannot be blank.")
        @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters.")
        String lastName,

        @NotBlank(message = "Email cannot be blank.")
        @Email(message = "Please provide a valid email address.")
        String email
) {
}
