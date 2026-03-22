package io.github.lorenasgc.vet.controller;

import io.github.lorenasgc.vet.dto.request.UpdateUserRequest;
import io.github.lorenasgc.vet.dto.response.UserResponse;
import io.github.lorenasgc.vet.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "Users", description = "Endpoints for managing clinic staff (User CRUD)")
public class UserController {
    private final UserService userService;

    @Operation(
            summary = "Retrieve all users",
            description = "Returns a complete list of all registered users in the clinic. If no users exist in the database, it returns a No Content status."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of users retrieved successfully"),
            @ApiResponse(responseCode = "204", description = "No users found in the database", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden: Missing or invalid JWT token", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.findAllUsers();
        return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }

    @Operation(
            summary = "Retrieve a user by their ID",
            description = "Searches the database for a specific user using their unique identifier."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied (e.g., negative number)", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden: Missing or invalid JWT token", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found with the specified ID", content = @Content)
    })
    @GetMapping("/{id}")
    public UserResponse getUserById(
            @Parameter(description = "User ID", required = true, example = "1") @PathVariable @Min(value = 1, message = "ID must be greater than or equal to 1") Long id) {
        return userService.findUserById(id);
    }

    @Operation(
            summary = "Update an existing user",
            description = "Updates the profile information (first name, last name, and email) of an existing user by their ID. Passwords and roles cannot be modified through this endpoint."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data or email already in use", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden: Missing or invalid JWT token", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found with the specified ID", content = @Content)
    })
    @PutMapping("/{id}")
    public UserResponse updateUser(
            @Parameter(description = "User ID", required = true, example = "1") @PathVariable @Min(value = 1, message = "ID must be greater than or equal to 1") Long id,
            @Valid @RequestBody UpdateUserRequest request) {

        return userService.updateUser(id, request);
    }

    @Operation(
            summary = "Soft delete a user",
            description = "Deactivates a user account by setting their status to inactive instead of permanently deleting their record from the database. This preserves historical medical records linked to this user."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User successfully deactivated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied (e.g., negative number)", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden: Missing or invalid JWT token", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found with the specified ID", content = @Content)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateUser(
            @Parameter(description = "User ID", required = true, example = "1") @PathVariable @Min(value = 1, message = "ID must be greater than or equal to 1") Long id) {
        userService.deactivateUser(id);
    }
}
