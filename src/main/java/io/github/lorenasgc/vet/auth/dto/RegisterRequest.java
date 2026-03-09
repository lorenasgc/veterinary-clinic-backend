package io.github.lorenasgc.vet.auth.dto;

public record RegisterRequest(String firstName,
                              String lastName,
                              String email,
                              String password) {

}
