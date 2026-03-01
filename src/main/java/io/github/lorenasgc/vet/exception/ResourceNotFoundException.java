package io.github.lorenasgc.vet.exception;

/**
 * Thrown when a requested resource (e.g., a PetOwner with a specific ID) is not found.
 * This is a business logic exception that will be handled by the GlobalExceptionHandler
 * to produce a 404 Not Found response.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
