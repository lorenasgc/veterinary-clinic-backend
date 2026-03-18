package io.github.lorenasgc.vet.controller;

import io.github.lorenasgc.vet.dto.response.UserResponse;
import io.github.lorenasgc.vet.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            @ApiResponse(responseCode = "204", description = "No users found in the database", content = @Content)
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
            @ApiResponse(responseCode = "404", description = "User not found with the specified ID", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(
            @PathVariable @Min(value = 1, message = "ID must be greater than or equal to 1") Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }
}
